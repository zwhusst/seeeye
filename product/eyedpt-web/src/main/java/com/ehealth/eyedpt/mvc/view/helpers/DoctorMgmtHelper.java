/*
 * Created on 2011-8-21
 */

package com.ehealth.eyedpt.mvc.view.helpers;

import java.util.ArrayList;
import java.util.List;

import com.ehealth.eyedpt.dal.entities.Doctor;
import com.ehealth.eyedpt.mvc.context.BeanResolver;
import com.ehealth.eyedpt.mvc.services.DoctorService;
import com.ehealth.eyedpt.mvc.view.models.DoctorMgmtItem;

/**
 * @author emac
 */
public enum DoctorMgmtHelper
{

    INSTANCE;

    private static DoctorService doctorService;

    static
    {
        doctorService = BeanResolver.getBean(DoctorService.class);
    }

    /**
     * Returns all registered doctors.
     * 
     * @return
     */
    public List<DoctorMgmtItem> getItems()
    {
        ArrayList<DoctorMgmtItem> items = new ArrayList<DoctorMgmtItem>();
        for (Doctor d : doctorService.findAll())
        {
            DoctorMgmtItem item = new DoctorMgmtItem(d.getUser().getName(), d.getRealname(), d.getGender(),
                    d.getEmployeeid(), d.getTitle(), d.getAdmintitle());
            items.add(item);
        }

        return items;
    }

}