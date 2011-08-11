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
import com.ehealth.eyedpt.mvc.components.MessageSourceProvider;
import com.ehealth.eyedpt.mvc.controllers.PatientController;
import com.ehealth.eyedpt.mvc.messages.ViewMessages;
import com.ehealth.eyedpt.mvc.view.models.UserPanelItem;

/**
 * @author emac
 */
@Service
public class GroupBasedUserPanelItemFactory
        implements IUserPanelItemFactory
{

    @Autowired
    private MessageSourceProvider msp;

    @Override
    public List<UserPanelItem> getItems(User user)
    {
        ArrayList<UserPanelItem> items = new ArrayList<UserPanelItem>();
        switch (user.getUsergroup())
        {
            case PATIENT:
            {
                fillPatientItems(items);
                break;
            }
            case DOCTOR:
            {
                fillDoctorItems(items);
                break;
            }
            case ADMIN:
            {
                fillAdminItems(items);
                break;
            }
            default:
            {
                break;
            }
        }

        return Collections.unmodifiableList(items);
    }

    private void fillPatientItems(List<UserPanelItem> items)
    {
        UserPanelItem profileItem = new UserPanelItem();
        profileItem.setName(this.msp.getMessage(ViewMessages.VW_PROFILE));
        profileItem.setHref(PatientController.MAPPING_EDIT);

        items.add(profileItem);
    }

    private void fillDoctorItems(List<UserPanelItem> items)
    {
        // TODO#EMAC
        UserPanelItem profileItem = new UserPanelItem();
        profileItem.setName(this.msp.getMessage(ViewMessages.VW_PROFILE));
        profileItem.setHref("#");

        items.add(profileItem);
    }

    private void fillAdminItems(List<UserPanelItem> items)
    {
        // TODO#EMAC
        UserPanelItem profileItem = new UserPanelItem();
        profileItem.setName(this.msp.getMessage(ViewMessages.VW_PROFILE));
        profileItem.setHref("#");

        items.add(profileItem);
    }

}
