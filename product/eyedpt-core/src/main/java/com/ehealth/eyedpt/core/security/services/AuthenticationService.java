/*
 * Created on 2011-8-22
 */

package com.ehealth.eyedpt.core.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.ehealth.eyedpt.dal.entities.User;

/**
 * @author emac
 */
@Service
public class AuthenticationService
{

    @Autowired
    @Qualifier("myAuthenticationManager")
    private AuthenticationManager authenticationManager;

    /**
     * Resets current spring authentication to the given user.
     * 
     * @param user
     */
    public void resetAuthentication(User user)
    {
        if ( user == null )
        {
            return;
        }

        Authentication token = new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword());
        Authentication authentication = this.authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

}
