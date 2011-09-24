/*
 * Created on 2011-9-20
 */

package com.ehealth.eyedpt.mvc.view.helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;

import com.ehealth.eyedpt.dal.entities.BookingRoster;
import com.ehealth.eyedpt.dal.entities.Doctor;
import com.ehealth.eyedpt.mvc.context.BeanResolver;
import com.ehealth.eyedpt.mvc.services.BookingRosterService;
import com.ehealth.eyedpt.mvc.services.DoctorService;
import com.ehealth.eyedpt.mvc.utils.CharsetUtils;
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
        if ( StringUtils.isEmpty(employeeId) )
        {
            return Collections.emptyList();
        }

        employeeId = CharsetUtils.translate(employeeId);
        Doctor doctor = doctorService.findByEmployeeId(employeeId);
        Assert.notNull(doctor);

        ArrayList<BookingRosterItem> items = new ArrayList<BookingRosterItem>();
        for (BookingRoster br : bookingRosterService.findByDoctor(doctor))
        {
            BookingRosterItem item = new BookingRosterItem(br.getDayofweek(), br.getTimeslot(), br.getCapability());
            items.add(item);
        }

        return items;
    }

}
