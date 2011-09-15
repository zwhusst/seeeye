/*
 * Created on 2011-8-1
 */

package com.ehealth.eyedpt.mvc.services;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.ehealth.eyedpt.dal.entities.Admin;
import com.ehealth.eyedpt.dal.entities.Doctor;
import com.ehealth.eyedpt.dal.entities.Patient;
import com.ehealth.eyedpt.dal.entities.User;
import com.ehealth.eyedpt.dal.repositories.AdminDao;
import com.ehealth.eyedpt.dal.repositories.DoctorDao;
import com.ehealth.eyedpt.dal.repositories.PatientDao;
import com.ehealth.eyedpt.dal.repositories.UserDao;

/**
 * @author emac
 */
@Service
public class UserService
{

    @Autowired
    private UserDao    userDao;

    @Autowired
    private AdminDao   adminDao;

    @Autowired
    private DoctorDao  doctorDao;

    @Autowired
    private PatientDao patientDao;

    /**
     * @param name
     * @return
     */
    public User findByName(String name)
    {
        return this.userDao.findByName(name.toLowerCase());
    }

    /**
     * @param user
     */
    public User update(User user)
    {
        return this.userDao.update(user);
    }

    /**
     * Tries to find email of the given user. Returns empty string if not found.
     * 
     * @param user
     * @return
     */
    public String getEmail(User user)
    {
        if ( user == null )
        {
            return "";
        }

        switch (user.getUsergroup())
        {
            case ADMIN:
            {
                Admin admin = this.adminDao.findByUser(user);
                Assert.notNull(admin);

                return admin.getEmail();
            }
            case DOCTOR:
            {
                Doctor doctor = this.doctorDao.findByUser(user);
                Assert.notNull(doctor);

                return doctor.getEmail();
            }
            case PATIENT:
            {
                Patient patient = this.patientDao.findByUser(user);
                Assert.notNull(patient);

                return patient.getEmail();
            }
            default:
                break;
        }

        return "";
    }

    /**
     * Generates a random password and makes it new password of the given user.
     * 
     * @param user
     * @return
     */
    public String resetPassword(User user)
    {
        if ( user == null )
        {
            return "";
        }

        String newPwd = RandomStringUtils.randomAlphanumeric(6);
        user.setPassword(newPwd);
        update(user);

        return newPwd;
    }

}
