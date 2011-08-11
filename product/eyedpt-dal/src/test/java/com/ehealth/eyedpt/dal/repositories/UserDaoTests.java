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
import com.ehealth.eyedpt.dal.entities.enums.UserGroup;

/**
 * @author emac
 */
@ContextConfiguration("classpath:WEB-INF/spring/context-jpa.xml")
public class UserDaoTests extends AbstractTransactionalJUnit4SpringContextTests
{

    private static final String TEST_USER_NAME         = "testuser";
    private static final String TEST_USER_PASSWORD     = "testpwd";
    private static final String TEST_USER_PASSWORD_NEW = "testpwdnew";

    @Autowired
    private UserDao             userDao;

    @Test
    public void testFindAll()
    {
        List<User> users = this.userDao.findAll();
        Assert.assertTrue(users.size() > 0);
    }

    @Test
    public void testCreate()
    {
        int oldSize = this.userDao.findAll().size();

        User user = new User();
        user.setName(TEST_USER_NAME);
        user.setPassword(TEST_USER_PASSWORD);
        user.setUsergroup(UserGroup.ADMIN);
        user.setRoleset(new byte[]
        { 0});
        this.userDao.create(user);

        int newSize = this.userDao.findAll().size();
        Assert.assertEquals(oldSize + 1, newSize);
    }

    @Test(expected = Exception.class)
    public void testCreateFail()
    {
        User user = new User();
        user.setName(TEST_USER_NAME);
        user.setPassword(TEST_USER_PASSWORD);
        this.userDao.create(user);
    }

    @Test
    public void testUpdate()
    {
        testCreate();

        User user = this.userDao.findByName(TEST_USER_NAME);
        Assert.assertNotNull(user);

        user.setPassword(TEST_USER_PASSWORD_NEW);
        this.userDao.update(user);

        user = this.userDao.findByName(TEST_USER_NAME);
        Assert.assertEquals(user.getPassword(), TEST_USER_PASSWORD_NEW);
    }

    @Test
    public void testDelete()
    {
        testCreate();

        User user = this.userDao.findByName(TEST_USER_NAME);
        Assert.assertNotNull(user);

        this.userDao.delete(user);
        Assert.assertNull(this.userDao.findByName(TEST_USER_NAME));
    }

}
