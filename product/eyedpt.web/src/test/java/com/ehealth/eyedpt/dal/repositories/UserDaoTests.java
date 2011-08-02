/*
 * Created on 2011-7-31
 */

package com.ehealth.eyedpt.dal.repositories;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.ehealth.eyedpt.dal.entities.User;

/**
 * @author emac
 */
@ContextConfiguration("classpath:context-jpa.xml")
public class UserDaoTests extends AbstractTransactionalJUnit4SpringContextTests
{

    private static final String TEST_USER_NAME = UserDaoTests.class.getName();

    @Autowired
    private UserDao             userDao;

    @Test
    public void testFindAll()
    {
        List<User> users = this.userDao.findAll();
        Assert.assertTrue(users.size() == 0);
    }

    @Test
    public void testCreate()
    {
        int oldSize = this.userDao.findAll().size();

        User user = new User();
        user.setName(TEST_USER_NAME);
        user.setPassword("");
        user.setUsergroup("ADMIN");
        user.setRoleset(new byte[]
        { 0});
        userDao.create(user);

        int newSize = this.userDao.findAll().size();
        Assert.assertEquals(oldSize + 1, newSize);
    }

    @Test
    public void testUpdate()
    {
        testCreate();
        
        List<User> users = this.userDao.findByName(TEST_USER_NAME);
        Assert.assertTrue(users.size() > 0);

        User user = users.get(0);
        user.setPassword("NewPassword");
        this.userDao.update(user);

        user = this.userDao.findByName(TEST_USER_NAME).get(0);
        Assert.assertEquals(user.getPassword(), "NewPassword");
    }

    @Test
    public void testDelete()
    {
        testCreate();
        
        List<User> users = this.userDao.findByName(TEST_USER_NAME);
        Assert.assertTrue(users.size() > 0);

        for (User user : users)
        {
            this.userDao.delete(user);
        }
        Assert.assertEquals(0, this.userDao.findByName(TEST_USER_NAME).size());
    }
}
