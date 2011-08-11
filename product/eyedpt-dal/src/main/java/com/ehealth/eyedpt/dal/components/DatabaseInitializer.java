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
import com.ehealth.eyedpt.dal.repositories.PatientDao;

/**
 * @author emac
 */
@Component
public class DatabaseInitializer
        implements ApplicationListener<ContextRefreshedEvent>
{

    private static Logger logger = Logger.getLogger(DatabaseInitializer.class);

    @Autowired
    private AdminDao      adminDao;

    @Autowired
    private PatientDao    patientDao;

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
        createSamplePatient();
    }

    private void createRootAdmin()
    {
        // user
        User superUser = new User();
        superUser.setName("root");
        superUser.setPassword("r00t");
        superUser.setUsergroup(UserGroup.ADMIN);
        superUser.setRoleset(new byte[]
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1});

        // hospital
        Hospital firstHospital = new Hospital();
        firstHospital.setName("上海市第一人民医院");
        firstHospital.setProvince("上海");
        firstHospital.setCity("上海");
        firstHospital.setAddress("虹口区海宁路100号(近吴淞路)");
        firstHospital.setPostcode("200080");
        firstHospital.setTelephone("021-63240090");

        // department
        Department seeeyeDep = new Department();
        seeeyeDep.setHospital(firstHospital);
        seeeyeDep.setName("眼科");
        seeeyeDep.setFamous(true);

        // admin
        Admin root = new Admin();
        root.setUser(superUser);
        root.setRoot(true);
        root.setEmail("root@seeeye.org");
        root.setHospital(firstHospital);
        root.setDepartments(Collections.singleton(seeeyeDep));

        this.adminDao.create(root);

        logger.info("Super user created!");
    }

    private void createSamplePatient()
    {
        // user
        User sampleUser = new User();
        sampleUser.setName("samplep");
        sampleUser.setPassword("samplep");
        sampleUser.setUsergroup(UserGroup.PATIENT);
        sampleUser.setRoleset(new byte[]
        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});

        // patient
        Patient samplePatient = new Patient();
        samplePatient.setUser(sampleUser);
        samplePatient.setRealname("test");
        samplePatient.setGender(Gender.M);
        samplePatient.setAge(99);
        samplePatient.setProvince("test");
        samplePatient.setCity("test");
        samplePatient.setRegistrytype(RegistryType.ID);
        samplePatient.setRegistryno("test");
        samplePatient.setEmail("test@seeeye.org");
        samplePatient.setCellphone("11111111111");

        this.patientDao.create(samplePatient);

        logger.info("Sample patient created!");
    }

}
