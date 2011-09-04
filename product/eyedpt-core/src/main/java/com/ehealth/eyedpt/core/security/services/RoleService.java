/*
 * Created on 2011-8-17
 */

package com.ehealth.eyedpt.core.security.services;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.ehealth.eyedpt.core.security.Role;
import com.ehealth.eyedpt.dal.entities.User;

/**
 * @author emac
 */
@Service
public class RoleService
{

    /**
     * Grants the given role to the given user.
     * 
     * @param user
     * @param role
     */
    public void grantRole(User user, Role role)
    {
        Assert.notNull(user);
        Assert.notNull(role);

        user.getRoleset()[role.idx] = Role.GRANTED;
    }

    /**
     * Grants the given roles to the given user.
     * 
     * @param user
     * @param roles
     */
    public void grantRoles(User user, Role[] roles)
    {
        Assert.notNull(user);
        Assert.notNull(roles);

        byte[] rs = user.getRoleset();
        for (Role r : roles)
        {
            rs[r.idx] = Role.GRANTED;
        }
    }

    /**
     * Checks whether the given user has been granted the given role.
     * 
     * @return
     */
    public boolean isGrantedRole(User user, Role role)
    {
        Assert.notNull(user);
        Assert.notNull(role);

        return user.getRoleset()[role.idx] == Role.GRANTED;
    }

}
