/*
 * Created on 2011-8-20
 */

package com.ehealth.eyedpt.mvc.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.ehealth.eyedpt.dal.components.DatabaseInitializer;
import com.ehealth.eyedpt.dal.entities.Admin;
import com.ehealth.eyedpt.dal.entities.Department;
import com.ehealth.eyedpt.dal.entities.Hospital;
import com.ehealth.eyedpt.dal.entities.User;
import com.ehealth.eyedpt.dal.entities.enums.UserGroup;
import com.ehealth.eyedpt.dal.repositories.AdminDao;
import com.ehealth.eyedpt.dal.repositories.DepartmentDao;
import com.ehealth.eyedpt.dal.repositories.HospitalDao;
import com.ehealth.eyedpt.dal.repositories.UserDao;
import com.ehealth.eyedpt.mvc.form.models.AdminBean;

/**
 * @author emac
 */
@Service
public class AdminService
{

    @Autowired
    private UserDao       userDao;

    @Autowired
    private AdminDao      adminDao;

    @Autowired
    private HospitalDao   hospitalDao;

    @Autowired
    private DepartmentDao departmentDao;

    /**
     * @return
     */
    public List<Admin> findAll()
    {
        return this.adminDao.findAll();
    }

    /**
     * @param user
     * @return
     */
    public Admin findByUser(User user)
    {
        return this.adminDao.findByUser(user);
    }

    /**
     * @param bean
     * @return
     */
    public Admin createAdmin(AdminBean bean)
    {
        User user = new User();
        user.setName(bean.getName());
        user.setPassword(bean.getPassword());
        user.setUsergroup(UserGroup.ADMIN);

        Admin admin = new Admin();
        admin.setUser(user);
        admin.setEmail(bean.getEmail());
        // TODO#EMAC.P! set roleset

        admin.setRoot(false);
        Hospital hospital = this.hospitalDao.findByName(DatabaseInitializer.HOSTPITAL_NO1);
        admin.setHospital(hospital);
        this.adminDao.create(admin);

        // to set many-to-many fields which already exist, must use update statement
        Department department = this.departmentDao.findByHospitalAndName(hospital, DatabaseInitializer.DEPARTMENT_EYE);
        admin.setDepartments(Collections.singleton(department));
        this.adminDao.update(admin);

        return admin;
    }

    /**
     * @param bean
     */
    public Admin updateAdmin(AdminBean bean)
    {
        User user = this.userDao.findByName(bean.getName());
        Assert.notNull(user);

        Admin admin = findByUser(user);
        admin.setEmail(bean.getEmail());

        this.adminDao.update(admin);

        return admin;
    }

}
