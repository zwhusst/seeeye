/*
 * Created on 2011-8-9
 */

package com.ehealth.eyedpt.dal.beans;

import java.util.HashSet;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.ehealth.eyedpt.dal.entities.Admin;
import com.ehealth.eyedpt.dal.entities.Department;
import com.ehealth.eyedpt.dal.entities.Hospital;
import com.ehealth.eyedpt.dal.entities.User;
import com.ehealth.eyedpt.dal.entities.enums.UserGroup;
import com.ehealth.eyedpt.dal.repositories.AdminDao;

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
        HashSet<Department> deps = new HashSet<Department>();
        deps.add(seeeyeDep);
        root.setDepartments(deps);

        this.adminDao.create(root);

        logger.info("Super user created!");
    }

}
