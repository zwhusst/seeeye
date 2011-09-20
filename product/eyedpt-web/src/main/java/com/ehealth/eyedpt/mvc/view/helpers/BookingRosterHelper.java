/*
 * Created on 2011-9-20
 */

package com.ehealth.eyedpt.mvc.view.helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ehealth.eyedpt.dal.entities.BookingRoster;
import com.ehealth.eyedpt.dal.entities.Doctor;
import com.ehealth.eyedpt.mvc.context.BeanResolver;
import com.ehealth.eyedpt.mvc.services.BookingRosterService;
import com.ehealth.eyedpt.mvc.services.DoctorService;
import com.ehealth.eyedpt.mvc.view.models.BookingRosterItem;

/**
 * Utility class to create items in booking roster page.
 * 
 * @author emac
 */
public enum BookingRosterHelper
{

    INSTANCE;

    private static DoctorService        doctorService;
    private static BookingRosterService bookingRosterService;

    static
    {
        doctorService = BeanResolver.getBean(DoctorService.class);
        bookingRosterService = BeanResolver.getBean(BookingRosterService.class);
    }

    public List<BookingRosterItem> getItems(String employeeId)
    {
        Doctor doctor = doctorService.findByEmployeeId(employeeId);
        if ( doctor == null )
        {
            return Collections.emptyList();
        }

        ArrayList<BookingRosterItem> items = new ArrayList<BookingRosterItem>();
        for (BookingRoster br : bookingRosterService.findByDoctor(doctor))
        {
            BookingRosterItem item = new BookingRosterItem(br.getDayofweek(), br.getTimeslot(), br.getCapability());
            items.add(item);
        }

        return items;
    }

}
