/*
 * Created on 2011-8-9
 */

package com.ehealth.eyedpt.mvc.services.userpanel;

import java.util.List;

import com.ehealth.eyedpt.dal.entities.User;
import com.ehealth.eyedpt.mvc.view.models.UserPanelItem;

/**
 * Factory to create items shown in user control panel.
 * 
 * @author emac
 */
public interface IUserPanelItemFactory
{

    /**
     * Produces a bunch of {@code UserPanelItem} for the given user.
     * 
     * @param user
     * @return
     */
    public List<UserPanelItem> getItems(User user);

}
