/*
 * Created on 2011-8-9
 */

package com.ehealth.eyedpt.mvc.services.userpanel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehealth.eyedpt.dal.entities.User;
import com.ehealth.eyedpt.dal.entities.enums.UserGroup;
import com.ehealth.eyedpt.mvc.components.MessageSourceProvider;
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
    private MessageSourceProvider msp;

    @Override
    public List<UserPanelItem> getItems(User user)
    {
        ArrayList<UserPanelItem> items = new ArrayList<UserPanelItem>();

        // TODO#EMAC.P1 integrate with Spring security framework
        if ( UserGroup.ADMIN != user.getUsergroup() )
        {
            return items;
        }

        UserPanelItem regDoctorItem = new UserPanelItem();
        regDoctorItem.setName(this.msp.getMessage(ViewMessages.VW_REGISTER_DOCTOR));
        regDoctorItem.setHref("#");
        items.add(regDoctorItem);

        UserPanelItem regAdminItem = new UserPanelItem();
        regAdminItem.setName(this.msp.getMessage(ViewMessages.VW_REGISTER_ADMIN));
        regAdminItem.setHref("#");
        items.add(regAdminItem);

        return Collections.unmodifiableList(items);
    }

}
