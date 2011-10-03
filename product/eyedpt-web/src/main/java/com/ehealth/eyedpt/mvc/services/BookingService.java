/*
 * Created on 2011-9-27
 */

package com.ehealth.eyedpt.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehealth.eyedpt.dal.entities.Booking;
import com.ehealth.eyedpt.dal.entities.enums.BookingStatus;
import com.ehealth.eyedpt.dal.repositories.BookingDao;

/**
 * @author emac
 */
@Service
public class BookingService
{

    @Autowired
    private BookingDao bookingDao;

    /**
     * @param status
     * @return
     */
    public List<Booking> findByStatus(BookingStatus status)
    {
        return this.bookingDao.findByStatus(status);
    }

    /**
     * @param bookingId
     * @return
     */
    public Booking findById(Long bookingId)
    {
        return this.bookingDao.findByBookingId(bookingId);
    }

}
