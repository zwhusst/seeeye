/*
 * Created on 2011-8-12
 */

package com.ehealth.eyedpt.dal.repositories;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.ehealth.eyedpt.dal.components.DatabaseInitializer;
import com.ehealth.eyedpt.dal.entities.Doctor;
import com.ehealth.eyedpt.dal.entities.User;

/**
 * @author emac
 */
@ContextConfiguration("classpath:WEB-INF/spring/context-jpa.xml")
public class DoctorDaoTests extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    private UserDao   userDao;

    @Autowired
    private DoctorDao doctorDao;

    @Test
    public void testDelete()
    {
        User user = this.userDao.findByName(DatabaseInitializer.TEST_DOCTOR);
        Assert.assertNotNull(user);

        Doctor doctor = this.doctorDao.findByUser(user);
        Assert.assertNotNull(doctor);

        this.doctorDao.delete(doctor);

        user = this.userDao.findByName(DatabaseInitializer.TEST_DOCTOR);
        Assert.assertNull(user);
    }

}
