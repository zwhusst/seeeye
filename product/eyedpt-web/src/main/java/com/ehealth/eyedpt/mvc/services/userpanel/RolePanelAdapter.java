/*
 * Created on 2011-8-20
 */

package com.ehealth.eyedpt.mvc.services.userpanel;

import java.util.HashMap;
import java.util.Map;

import com.ehealth.eyedpt.core.security.Role;
import com.ehealth.eyedpt.mvc.components.MessageSourceProvider;
import com.ehealth.eyedpt.mvc.context.BeanResolver;
import com.ehealth.eyedpt.mvc.controllers.AdminController;
import com.ehealth.eyedpt.mvc.controllers.DoctorController;
import com.ehealth.eyedpt.mvc.messages.ViewMessages;
import com.ehealth.eyedpt.mvc.view.models.UserPanelItem;

/**
 * @author emac
 */
public class RolePanelAdapter
{

    private static final Map<Role, UserPanelItem> MAP;
    private static MessageSourceProvider          msp;

    static
    {
        msp = BeanResolver.getBean(MessageSourceProvider.class);

        MAP = new HashMap<Role, UserPanelItem>();
        UserPanelItem item;

        // patient

        // doctor
        item = new UserPanelItem(msp.getMessage(ViewMessages.VW_DOCTOR_MGMT), DoctorController.MAPPING_MGMT);
        MAP.put(Role.DOCTOR_ADMIN, item);

        // admin
        item = new UserPanelItem(msp.getMessage(ViewMessages.VW_ADMIN_MGMT), AdminController.MAPPING_MGMT);
        MAP.put(Role.ADMIN_ADMIN, item);

        // booking

        // blacklist

        // consulting
    }

    /**
     * Returns the user panel item which is bound to the given role.
     * 
     * @param role
     * @return
     */
    public static UserPanelItem adapt(Role role)
    {
        return MAP.get(role);
    }

}
