/*
 * Created on 2011-8-21
 */

package com.ehealth.eyedpt.mvc.view.helpers;

import java.util.HashMap;
import java.util.Map;

import com.ehealth.eyedpt.core.security.Role;
import com.ehealth.eyedpt.mvc.components.MessageSourceProvider;
import com.ehealth.eyedpt.mvc.context.BeanResolver;
import com.ehealth.eyedpt.mvc.messages.ViewMessages;

/**
 * Utility class to list all grantable roles.
 * 
 * @author emac
 */
public enum RoleHelper
{

    INSTANCE;

    public static final Map<Role, String> ROLESET;

    private static MessageSourceProvider  msp;

    static
    {
        msp = BeanResolver.getBean(MessageSourceProvider.class);

        ROLESET = new HashMap<Role, String>();
        ROLESET.put(Role.DOCTOR_ADMIN, msp.getMessage(ViewMessages.VW_DOCTOR_MGMT));
        ROLESET.put(Role.BOOKING_ADMIN, msp.getMessage(ViewMessages.VW_BOOKING_MGMT));
        ROLESET.put(Role.CONSULTING_ADMIN, msp.getMessage(ViewMessages.VW_CONSULTING_MGMT));
    }

}
