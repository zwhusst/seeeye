/*
 * Created on 2011-9-25
 */

package com.ehealth.eyedpt.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.ehealth.eyedpt.dal.entities.BookingEx;
import com.ehealth.eyedpt.dal.entities.Doctor;
import com.ehealth.eyedpt.dal.entities.DoctorCap;

/**
 * Provides miscellaneous services related to booking.
 * <p>
 * A service facade should be composed of only services.
 * 
 * @author emac
 */
@Service
public class BookingFacade
{

    @Autowired
    private DoctorService        doctorService;

    @Autowired
    private BookingRosterService bookingRosterService;

    @Autowired
    private BookingExService     bookingExService;

    @Autowired
    private DoctorCapService     doctorCapService;

    /**
     * Stops providing booking service of doctor with the given employee ID.
     * 
     * @param employeeId
     */
    public void declineBookings(String employeeId)
    {
        Doctor doctor = this.doctorService.findByEmployeeId(employeeId);
        Assert.notNull(doctor);

        // reset roster
        this.bookingRosterService.deleteAll(doctor);

        // clean booking exception
        BookingEx ex = this.bookingExService.findByDoctor(doctor);
        if ( ex != null )
        {
            this.bookingExService.delete(ex);
        }

        // update capability
        DoctorCap cap = this.doctorCapService.findByDoctor(doctor);
        Assert.notNull(cap);

        cap.setAcceptbookings(false);
        this.doctorCapService.update(cap);
    }

}
