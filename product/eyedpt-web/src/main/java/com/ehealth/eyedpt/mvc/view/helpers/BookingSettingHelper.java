/*
 * Created on 2011-9-18
 */

package com.ehealth.eyedpt.mvc.view.helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ehealth.eyedpt.dal.entities.Doctor;
import com.ehealth.eyedpt.mvc.context.BeanResolver;
import com.ehealth.eyedpt.mvc.services.BookingRosterService;
import com.ehealth.eyedpt.mvc.services.DoctorCapService;
import com.ehealth.eyedpt.mvc.services.DoctorService;
import com.ehealth.eyedpt.mvc.view.models.BookingSettingItem;

/**
 * Utility class to create items in booking setting page.
 * 
 * @author emac
 */
public enum BookingSettingHelper
{

    INSTANCE;

    private static DoctorService        doctorService;
    private static DoctorCapService     doctorCapService;
    private static BookingRosterService bookingRosterService;

    static
    {
        doctorService = BeanResolver.getBean(DoctorService.class);
        doctorCapService = BeanResolver.getBean(DoctorCapService.class);
        bookingRosterService = BeanResolver.getBean(BookingRosterService.class);
    }

    /**
     * Returns booking settings of all doctors.
     * 
     * @return
     */
    public List<BookingSettingItem> getItems()
    {
        ArrayList<BookingSettingItem> items = new ArrayList<BookingSettingItem>();
        for (Doctor d : doctorService.findAll())
        {
            String serviceTime = bookingRosterService.getServiceTime(d);
            boolean active = doctorCapService.acceptBookings(d);

            BookingSettingItem item = new BookingSettingItem(d.getRealname(), d.getEmployeeid(), d.getExpertrank(),
                    serviceTime, active);
            items.add(item);
        }

        return Collections.unmodifiableList(items);
    }

}
