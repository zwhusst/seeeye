/*
 * Created on 2011-9-27
 */

package com.ehealth.eyedpt.mvc.view.helpers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ehealth.eyedpt.dal.entities.Booking;
import com.ehealth.eyedpt.dal.entities.enums.BookingStatus;
import com.ehealth.eyedpt.mvc.context.BeanResolver;
import com.ehealth.eyedpt.mvc.services.BookingService;
import com.ehealth.eyedpt.mvc.view.models.BookingItem;

/**
 * Utility class to create items in booking management page.
 * 
 * @author emac
 */
public enum BookingHelper
{

    INSTANCE;

    private static BookingService bookingService;

    static
    {
        bookingService = BeanResolver.getBean(BookingService.class);
    }

    /**
     * Returns all booking items in the given status.
     * 
     * @return
     */
    public List<BookingItem> getItems(BookingStatus status)
    {
        ArrayList<BookingItem> items = new ArrayList<BookingItem>();
        for (Booking b : bookingService.findByStatus(status))
        {
            BookingItem item = new BookingItem(b.getBookingid(), b.getPatient().getRealname(), b.getDoctor()
                    .getRealname(), b.getBookingdate(), new Date(b.getPostdate().getTime()), b.getStatus());
            items.add(item);
        }

        return Collections.unmodifiableList(items);
    }

}
