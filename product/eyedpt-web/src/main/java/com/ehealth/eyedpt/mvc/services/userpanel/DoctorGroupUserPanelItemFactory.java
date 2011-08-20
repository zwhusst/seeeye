/*
 * Created on 2011-8-20
 */

package com.ehealth.eyedpt.mvc.services.userpanel;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ehealth.eyedpt.dal.entities.User;
import com.ehealth.eyedpt.mvc.view.models.UserPanelItem;

/**
 * @author emac
 */
@Service
public class DoctorGroupUserPanelItemFactory implements IUserPanelItemFactory
{

    @Override
    public List<UserPanelItem> getItems(User user)
    {
        // TODO#EMAC.P2 add general doctor panel items
        return Collections.emptyList();
    }

}
