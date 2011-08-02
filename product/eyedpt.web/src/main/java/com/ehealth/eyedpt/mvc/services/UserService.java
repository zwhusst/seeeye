/*
 * Created on 2011-8-1
 */

package com.ehealth.eyedpt.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehealth.eyedpt.dal.repositories.UserDao;

/**
 * @author emac
 */
@Service
public class UserService
{

    @Autowired
    private UserDao userDao;

}
