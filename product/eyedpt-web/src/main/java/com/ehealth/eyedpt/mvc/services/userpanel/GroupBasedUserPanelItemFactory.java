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
import com.ehealth.eyedpt.mvc.view.models.UserPanelItem;

/**
 * Factory to create items related to user group.
 * 
 * @author emac
 */
@Service
public class GroupBasedUserPanelItemFactory
        implements IUserPanelItemFactory
{

    @Autowired
    private PatientGroupUserPanelItemFactory patientFactory;

    @Autowired
    private DoctorGroupUserPanelItemFactory  doctorFactory;

    @Override
    public List<UserPanelItem> getItems(User user)
    {
        if ( user == null )
        {
            return Collections.emptyList();
        }

        ArrayList<UserPanelItem> items = new ArrayList<UserPanelItem>();
        switch (user.getUsergroup())
        {
            case PATIENT:
            {
                items.addAll(this.patientFactory.getItems(user));
                break;
            }
            case DOCTOR:
            {
                items.addAll(this.doctorFactory.getItems(user));
                break;
            }
            default:
            {
                break;
            }
        }

        return Collections.unmodifiableList(items);
    }

}
