/*
 * Created on 2011-8-15
 */

package com.ehealth.eyedpt.core.security;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.ehealth.eyedpt.dal.entities.User;
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
        if ( StringUtils.isEmpty(username) )
        {
            throw new UsernameNotFoundException("");
        }

        User user = this.userDao.findByName(username);
        if ( user == null )
        {
            throw new UsernameNotFoundException("");
        }

        // TODO#EMAC.P! read authorities
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new GrantedAuthorityImpl("patient"));

        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), true, true,
                true, true, authorities);
    }

}
