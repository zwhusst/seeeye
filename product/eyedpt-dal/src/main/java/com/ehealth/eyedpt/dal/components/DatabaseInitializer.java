/*
 * Created on 2011-8-9
 */

package com.ehealth.eyedpt.dal.components;

import java.util.Collections;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.ehealth.eyedpt.dal.entities.Admin;
import com.ehealth.eyedpt.dal.entities.Department;
import com.ehealth.eyedpt.dal.entities.Hospital;
import com.ehealth.eyedpt.dal.entities.Patient;
import com.ehealth.eyedpt.dal.entities.User;
import com.ehealth.eyedpt.dal.entities.enums.Gender;
import com.ehealth.eyedpt.dal.entities.enums.RegistryType;
import com.ehealth.eyedpt.dal.entities.enums.UserGroup;
import com.ehealth.eyedpt.dal.repositories.AdminDao;
import com.ehealth.eyedpt.dal.repositories.DepartmentDao;
import com.ehealth.eyedpt.dal.repositories.HospitalDao;
import com.ehealth.eyedpt.dal.repositories.PatientDao;

/**
 * @author emac
 */
@Component
public class DatabaseInitializer
        implements ApplicationListener<ContextRefreshedEvent>
{

    private static Logger      logger         = Logger.getLogger(DatabaseInitializer.class);

    public static final String TEST_PATIENT   = "tp";
    public static final String TEST_ADMIN     = "ta";
    public static final String TEST_DOCTOR    = "td";

    public static final String HOSTPITAL_NO1  = "上海市第一人民医院";
    public static final String DEPARTMENT_EYE = "眼科";

    @Autowired
    private AdminDao           adminDao;

    @Autowired
    private PatientDao         patientDao;

    @Autowired
    private HospitalDao        hospitalDao;

    @Autowired
    private DepartmentDao      departmentDao;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        initDB();
    }

    private void initDB()
    {
        if ( this.adminDao.findAll().size() > 0 )
        {
            return;
        }

        createRootAdmin();
        createTestAdmin();
        createTestPatient();
    }

    private void createRootAdmin()
    {
        // user
        User user = new User();
        user.setName("root");
        user.setPassword("r00t");
        user.setUsergroup(UserGroup.ADMIN);
        user.setRoleset(new byte[]
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1});

        // hospital
        Hospital firstHospital = new Hospital();
        firstHospital.setName(HOSTPITAL_NO1);
        firstHospital.setProvince("上海");
        firstHospital.setCity("上海");
        firstHospital.setAddress("虹口区海宁路100号(近吴淞路)");
        firstHospital.setPostcode("200080");
        firstHospital.setTelephone("021-63240090");

        // department
        Department eyeDep = new Department();
        eyeDep.setHospital(firstHospital);
        eyeDep.setName(DEPARTMENT_EYE);
        eyeDep.setFamous(true);

        // admin
        Admin root = new Admin();
        root.setUser(user);
        root.setRoot(true);
        root.setEmail("root@seeeye.org");
        root.setHospital(firstHospital);
        root.setDepartments(Collections.singleton(eyeDep));

        this.adminDao.create(root);

        logger.info("Super user created!");
    }

    private void createTestAdmin()
    {
        // user
        User user = new User();
        user.setName(TEST_ADMIN);
        user.setPassword(TEST_ADMIN);
        user.setUsergroup(UserGroup.ADMIN);
        user.setRoleset(new byte[]
        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});

        // admin
        Admin ta = new Admin();
        ta.setUser(user);
        ta.setRoot(false);
        ta.setEmail("ta@seeeye.org");

        Hospital hospital = this.hospitalDao.findByName(HOSTPITAL_NO1);
        ta.setHospital(hospital);
        this.adminDao.create(ta);

        Department department = this.departmentDao.findByHospitalAndName(hospital, DEPARTMENT_EYE);
        ta.setDepartments(Collections.singleton(department));
        this.adminDao.update(ta);

        logger.info("Test admin created!");
    }

    private void createTestPatient()
    {
        // user
        User user = new User();
        user.setName(TEST_PATIENT);
        user.setPassword(TEST_PATIENT);
        user.setUsergroup(UserGroup.PATIENT);
        user.setRoleset(new byte[]
        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});

        // patient
        Patient tp = new Patient();
        tp.setUser(user);
        tp.setRealname("test");
        tp.setGender(Gender.M);
        tp.setAge(99);
        tp.setProvince("test");
        tp.setCity("test");
        tp.setRegistrytype(RegistryType.ID);
        tp.setRegistryno("test");
        tp.setEmail("tp@seeeye.org");
        tp.setCellphone("11111111111");

        this.patientDao.create(tp);

        logger.info("Test patient created!");
    }

}
