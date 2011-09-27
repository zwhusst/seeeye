/*
 * Created on 2011-8-20
 */

package com.ehealth.eyedpt.mvc.view.helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ehealth.eyedpt.dal.entities.Admin;
import com.ehealth.eyedpt.mvc.context.BeanResolver;
import com.ehealth.eyedpt.mvc.services.AdminService;
import com.ehealth.eyedpt.mvc.view.models.AdminMgmtItem;

/**
 * Utility class to create items in admin management page.
 * 
 * @author emac
 */
public enum AdminMgmtHelper
{

    INSTANCE;

    private static AdminService adminService;

    static
    {
        adminService = BeanResolver.getBean(AdminService.class);
    }

    /**
     * Returns all non-root admins.
     * 
     * @return
     */
    public List<AdminMgmtItem> getItems()
    {
        ArrayList<AdminMgmtItem> items = new ArrayList<AdminMgmtItem>();
        for (Admin a : adminService.findAll())
        {
            if ( a.isRoot() )
            {
                // skip root admin
                continue;
            }

            AdminMgmtItem item = new AdminMgmtItem(a.getUser().getName());
            items.add(item);
        }

        return Collections.unmodifiableList(items);
    }

}
