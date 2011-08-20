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
import com.ehealth.eyedpt.mvc.constants.ViewConstants;
import com.ehealth.eyedpt.mvc.controllers.AdminController;
import com.ehealth.eyedpt.mvc.controllers.PatientController;
import com.ehealth.eyedpt.mvc.messages.ViewMessages;
import com.ehealth.eyedpt.mvc.view.models.UserPanelItem;

/**
 * @author emac
 */
@Service
public class UniversalUserPanelItemFactory
        implements IUserPanelItemFactory
{

    private static String         MAPPING_SPRING_LOGOUT = "/j_spring_security_logout";

    @Autowired
    private MessageSourceProvider msp;

    @Override
    public List<UserPanelItem> getItems(User user)
    {
        if ( user == null )
        {
            return Collections.emptyList();
        }

        ArrayList<UserPanelItem> items = new ArrayList<UserPanelItem>();
        // profile
        addEditProfileItem(user.getUsergroup(), items);

        // change password
        addChangePwdItem(items);

        // log out
        addLogoutItem(items);

        return Collections.unmodifiableList(items);
    }

    private void addEditProfileItem(UserGroup userGroup, List<UserPanelItem> items)
    {
        UserPanelItem profileItem = null;
        switch (userGroup)
        {
            case PATIENT:
            {
                profileItem = new UserPanelItem(this.msp.getMessage(ViewMessages.VW_PROFILE),
                        PatientController.MAPPING_EDIT);
                break;
            }
            case DOCTOR:
            {
                // TODO#EMAC.P0 add edit doctor panel item
                profileItem = new UserPanelItem(this.msp.getMessage(ViewMessages.VW_PROFILE), ViewConstants.HREF_TODO);
                break;
            }
            case ADMIN:
            {
                profileItem = new UserPanelItem(this.msp.getMessage(ViewMessages.VW_PROFILE),
                        AdminController.MAPPING_EDIT);
                break;
            }
            default:
            {
                break;
            }
        }

        if ( profileItem != null )
        {
            items.add(profileItem);
        }
    }

    private void addChangePwdItem(List<UserPanelItem> items)
    {
        UserPanelItem pwdItem = new UserPanelItem(this.msp.getMessage(ViewMessages.VW_CHNAGE_PWD),
                ViewConstants.HREF_TODO);

        items.add(pwdItem);
    }

    private void addLogoutItem(List<UserPanelItem> items)
    {
        UserPanelItem logoutItem = new UserPanelItem(this.msp.getMessage(ViewMessages.VW_LOGOUT), MAPPING_SPRING_LOGOUT);

        items.add(logoutItem);
    }

}
