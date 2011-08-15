/*
 * Created on 2011-8-15
 */

package com.ehealth.eyedpt.core.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.ehealth.eyedpt.dal.repositories.UserDao;

/**
 * @author emac
 */
@Component
public class MyUserDetailsService
        implements UserDetailsService
{

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException
    {
        // TODO#EMAC
        return null;
    }

}
