/*
 * Created on 2011-8-1
 */

package com.ehealth.eyedpt.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehealth.eyedpt.dal.entities.User;
import com.ehealth.eyedpt.dal.repositories.UserDao;

/**
 * @author emac
 */
@Service
public class UserService
{

    @Autowired
    private UserDao userDao;

    /**
     * @param name
     * @return
     */
    public List<User> findUserByName(String name)
    {
        return this.userDao.findByName(name);
    }

}
