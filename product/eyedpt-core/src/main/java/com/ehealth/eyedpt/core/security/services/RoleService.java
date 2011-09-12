/*
 * Created on 2011-8-17
 */

package com.ehealth.eyedpt.core.security.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.ehealth.eyedpt.core.security.Role;
import com.ehealth.eyedpt.dal.entities.User;

/**
 * Services to grant/revoke roles to/from any user.
 * 
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
     * Returns all granted roles to the given user.
     * 
     * @param user
     * @return
     */
    public List<Role> getGrantedRoles(User user)
    {
        ArrayList<Role> roles = new ArrayList<Role>();
        byte[] rs = user.getRoleset();
        for (int i = 0; i < rs.length; i++)
        {
            if ( rs[i] == Role.REVOKED )
            {
                continue;
            }

            Role role = Role.valueOf(i);
            if ( role != null )
            {
                roles.add(role);
            }
        }

        return Collections.unmodifiableList(roles);
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

    /**
     * Revokes all roles from the given user.
     * 
     * @param user
     */
    public void revokeAllRoles(User user)
    {
        Assert.notNull(user);

        // HAVE TO CREATE NEW BYTE ARRAY IN ORDER TO REVOKE ALL. UPDATE EXISTING ARRRY DOES NOT WORK IN SPRING CONTEXT.
        user.setRoleset(new byte[32]);
    }

}
