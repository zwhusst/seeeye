/*
 * Created on 2011-8-20
 */

package com.ehealth.eyedpt.mvc.services.userpanel;

import java.util.HashMap;
import java.util.Map;

import com.ehealth.eyedpt.core.security.Role;
import com.ehealth.eyedpt.mvc.components.MessageSourceProvider;
import com.ehealth.eyedpt.mvc.context.BeanResolver;
import com.ehealth.eyedpt.mvc.view.models.UserPanelItem;

/**
 * @author emac
 */
public class RolePanelAdapter
{

    private static final MessageSourceProvider    MSP;
    private static final Map<Role, UserPanelItem> MAP;

    static
    {
        MSP = BeanResolver.getBean(MessageSourceProvider.class);

        MAP = new HashMap<Role, UserPanelItem>();
        // doctor

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
