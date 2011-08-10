/*
 * Created on 2011-8-9
 */

package com.ehealth.eyedpt.mvc.services.userpanel;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehealth.eyedpt.dal.entities.User;
import com.ehealth.eyedpt.mvc.components.MessageSourceProvider;
import com.ehealth.eyedpt.mvc.controllers.UserController;
import com.ehealth.eyedpt.mvc.messages.ViewMessages;
import com.ehealth.eyedpt.mvc.view.models.UserPanelItem;

/**
 * @author emac
 */
@Service
public class UniversalUserPanelItemFactory
        implements IUserPanelItemFactory
{

    @Autowired
    private MessageSourceProvider msp;

    @Override
    public List<UserPanelItem> getItems(User user)
    {
        UserPanelItem logoutItem = new UserPanelItem();
        logoutItem.setName(this.msp.getMessage(ViewMessages.VW_LOGOUT));
        logoutItem.setHref(UserController.MAPPING_LOGOUT);

        return Collections.singletonList(logoutItem);
    }

}
