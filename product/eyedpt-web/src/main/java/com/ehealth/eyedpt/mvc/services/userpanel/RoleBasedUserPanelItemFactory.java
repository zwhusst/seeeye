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
import com.ehealth.eyedpt.dal.entities.User;
import com.ehealth.eyedpt.dal.entities.enums.UserGroup;
import com.ehealth.eyedpt.mvc.components.MessageSourceProvider;
import com.ehealth.eyedpt.mvc.constants.ViewConstants;
import com.ehealth.eyedpt.mvc.messages.ViewMessages;
import com.ehealth.eyedpt.mvc.view.models.UserPanelItem;

/**
 * @author emac
 */
@Service
public class RoleBasedUserPanelItemFactory
        implements IUserPanelItemFactory
{

    @Autowired
    protected MessageSourceProvider msp;

    @Override
    public List<UserPanelItem> getItems(User user)
    {
        if ( user == null || UserGroup.PATIENT == user.getUsergroup() )
        {
            return Collections.emptyList();
        }

        ArrayList<UserPanelItem> items = new ArrayList<UserPanelItem>();

        addBasicRoleItems(user.getRoleset(), items);

        // TODO#.P0 test root admin
        if ( UserGroup.ADMIN == user.getUsergroup() )
        {
            addRootAdminItems(items);
        }

        return Collections.unmodifiableList(items);
    }

    private void addBasicRoleItems(byte[] rs, List<UserPanelItem> items)
    {
        for (int i = 0; i < rs.length; i++)
        {
            if ( rs[i] == 0 )
            {
                continue;
            }

            Role role = Role.valueOf(i);
            UserPanelItem item = RolePanelAdapter.adapt(role);
            if ( item != null )
            {
                items.add(item);
            }
        }
    }

    private void addRootAdminItems(List<UserPanelItem> items)
    {
        UserPanelItem regAdminItem = new UserPanelItem(this.msp.getMessage(ViewMessages.VW_REG_ADMIN),
                ViewConstants.HREF_TODO);
        items.add(regAdminItem);
    }

}
