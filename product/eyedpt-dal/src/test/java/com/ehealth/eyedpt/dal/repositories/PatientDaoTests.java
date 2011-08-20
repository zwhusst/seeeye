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
import com.ehealth.eyedpt.dal.entities.Patient;
import com.ehealth.eyedpt.dal.entities.User;

/**
 * @author emac
 */
@ContextConfiguration("classpath:WEB-INF/spring/context-jpa.xml")
public class PatientDaoTests extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    private UserDao    userDao;

    @Autowired
    private PatientDao patientDao;

    @Test
    public void testFindByUser()
    {
        User user = this.userDao.findByName(DatabaseInitializer.TEST_PATIENT);
        Assert.assertNotNull(user);

        Patient patient = this.patientDao.findByUser(user);
        Assert.assertNotNull(patient);
    }

}
