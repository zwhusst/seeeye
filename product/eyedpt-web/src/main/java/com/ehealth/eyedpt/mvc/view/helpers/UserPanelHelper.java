/*
 * Created on 2011-8-9
 */

package com.ehealth.eyedpt.mvc.view.helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ehealth.eyedpt.dal.entities.User;
import com.ehealth.eyedpt.mvc.context.BeanResolver;
import com.ehealth.eyedpt.mvc.services.userpanel.GroupBasedUserPanelItemFactory;
import com.ehealth.eyedpt.mvc.services.userpanel.RoleBasedUserPanelItemFactory;
import com.ehealth.eyedpt.mvc.services.userpanel.UniversalUserPanelItemFactory;
import com.ehealth.eyedpt.mvc.view.models.UserPanelItem;

/**
 * Utility class to create items in user control panel.
 * 
 * @author emac
 */
public enum UserPanelHelper
{

    INSTANCE;

    private static GroupBasedUserPanelItemFactory groupFactory;
    private static RoleBasedUserPanelItemFactory  roleFactory;
    private static UniversalUserPanelItemFactory  uniFactory;

    static
    {
        groupFactory = BeanResolver.getBean(GroupBasedUserPanelItemFactory.class);
        roleFactory = BeanResolver.getBean(RoleBasedUserPanelItemFactory.class);
        uniFactory = BeanResolver.getBean(UniversalUserPanelItemFactory.class);
    }

    /**
     * Returns a bunch of {@code UserPanelItem} for the given user.
     * 
     * @param user
     * @return
     */
    public List<UserPanelItem> getItems(User user)
    {
        if ( user == null )
        {
            return Collections.emptyList();
        }

        ArrayList<UserPanelItem> items = new ArrayList<UserPanelItem>();
        items.addAll(groupFactory.getItems(user));
        items.addAll(roleFactory.getItems(user));
        items.addAll(uniFactory.getItems(user));

        return Collections.unmodifiableList(items);
    }

}
