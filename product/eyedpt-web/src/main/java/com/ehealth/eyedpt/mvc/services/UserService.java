/*
 * Created on 2011-8-1
 */

package com.ehealth.eyedpt.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehealth.eyedpt.dal.entities.User;
import com.ehealth.eyedpt.dal.entities.User.UserGroup;
import com.ehealth.eyedpt.dal.repositories.UserDao;

/**
 * @author emac
 */
@Service
public class UserService
{

    @Autowired
    private UserDao userDao;

    public List<User> findUserByName(String name)
    {
        return this.userDao.findByName(name);
    }

    public void createUser(String name, String password, UserGroup group)
    {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setUsergroup(group);
        this.userDao.create(user);
    }

}
