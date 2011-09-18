/*
 * Created on 2011-8-20
 */

package com.ehealth.eyedpt.mvc.services.userpanel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ehealth.eyedpt.core.security.Role;
import com.ehealth.eyedpt.mvc.components.MessageSourceProvider;
import com.ehealth.eyedpt.mvc.context.BeanResolver;
import com.ehealth.eyedpt.mvc.controllers.AdminController;
import com.ehealth.eyedpt.mvc.controllers.BookingController;
import com.ehealth.eyedpt.mvc.controllers.DoctorController;
import com.ehealth.eyedpt.mvc.messages.ViewMessages;
import com.ehealth.eyedpt.mvc.view.models.UserPanelItem;

/**
 * Adapts a user role to a user panel item if it applies.
 * 
 * @author emac
 */
public class RolePanelAdapter
{

    private static final Map<Role, List<UserPanelItem>> MAP;
    private static MessageSourceProvider                msp;

    static
    {
        msp = BeanResolver.getBean(MessageSourceProvider.class);

        MAP = new HashMap<Role, List<UserPanelItem>>();
        UserPanelItem item;

        // patient

        // doctor
        item = new UserPanelItem(msp.getMessage(ViewMessages.VW_DOCTOR_MGMT), DoctorController.MAPPING_MGMT);
        MAP.put(Role.DOCTOR_ADMIN, Collections.singletonList(item));

        // admin
        item = new UserPanelItem(msp.getMessage(ViewMessages.VW_ADMIN_MGMT), AdminController.MAPPING_MGMT);
        MAP.put(Role.ADMIN_ADMIN, Collections.singletonList(item));

        // booking
        ArrayList<UserPanelItem> items = new ArrayList<UserPanelItem>();
        item = new UserPanelItem(msp.getMessage(ViewMessages.VW_BOOKING_SETTING), BookingController.MAPPING_SETTING);
        items.add(item);
        item = new UserPanelItem(msp.getMessage(ViewMessages.VW_BOOKING_MGMT), BookingController.MAPPING_MGMT);
        items.add(item);
        MAP.put(Role.BOOKING_ADMIN, Collections.unmodifiableList(items));

        // blacklist

        // consulting
    }

    /**
     * Returns a list of user panel items which are bound to the given role.
     * 
     * @param role
     * @return
     */
    public static List<UserPanelItem> adapt(Role role)
    {
        return MAP.get(role);
    }

}
