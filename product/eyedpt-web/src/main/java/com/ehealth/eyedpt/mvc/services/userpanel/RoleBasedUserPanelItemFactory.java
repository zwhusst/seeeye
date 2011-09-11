/*
 * Created on 2011-8-9
 */

package com.ehealth.eyedpt.mvc.services.userpanel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehealth.eyedpt.core.security.Role;
import com.ehealth.eyedpt.core.security.services.RoleService;
import com.ehealth.eyedpt.dal.entities.User;
import com.ehealth.eyedpt.dal.entities.enums.UserGroup;
import com.ehealth.eyedpt.mvc.view.models.UserPanelItem;

/**
 * Factory to create items related to user roles.
 * 
 * @author emac
 */
@Service
public class RoleBasedUserPanelItemFactory
        implements IUserPanelItemFactory
{

    @Autowired
    private RoleService roleService;

    @Override
    public List<UserPanelItem> getItems(User user)
    {
        if ( user == null || UserGroup.PATIENT == user.getUsergroup() )
        {
            return Collections.emptyList();
        }

        ArrayList<UserPanelItem> items = new ArrayList<UserPanelItem>();

        adaptRolesToItems(this.roleService.getGrantedRoles(user), items);

        return Collections.unmodifiableList(items);
    }

    private void adaptRolesToItems(List<Role> roles, List<UserPanelItem> items)
    {
        for (Role role : roles)
        {
            UserPanelItem item = RolePanelAdapter.adapt(role);
            if ( item != null )
            {
                items.add(item);
            }
        }
    }

}
