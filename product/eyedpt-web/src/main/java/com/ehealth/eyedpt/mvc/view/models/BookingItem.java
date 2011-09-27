/*
 * Created on 2011-9-27
 */

package com.ehealth.eyedpt.mvc.view.models;

import java.util.Date;

import com.ehealth.eyedpt.dal.entities.enums.BookingStatus;

/**
 * @author emac
 */
public class BookingItem
{

    private long          bookingid;

    private String        patientname;

    private String        doctorname;

    private Date          bookingdate;

    private Date          postdate;

    private BookingStatus status;

    /**
     * @param bookingid
     * @param patientname
     * @param doctorname
     * @param bookingdate
     * @param postdate
     * @param status
     */
    public BookingItem(long bookingid, String patientname, String doctorname, Date bookingdate, Date postdate,
            BookingStatus status)
    {
        this.bookingid = bookingid;
        this.patientname = patientname;
        this.doctorname = doctorname;
        this.bookingdate = bookingdate;
        this.postdate = postdate;
        this.status = status;
    }

    /**
     * @return the bookingid
     */
    public long getBookingid()
    {
        return this.bookingid;
    }

    /**
     * @return the patientname
     */
    public String getPatientname()
    {
        return this.patientname;
    }

    /**
     * @return the doctorname
     */
    public String getDoctorname()
    {
        return this.doctorname;
    }

    /**
     * @return the bookingdate
     */
    public Date getBookingdate()
    {
        return this.bookingdate;
    }

    /**
     * @return the postdate
     */
    public Date getPostdate()
    {
        return this.postdate;
    }

    /**
     * @return the status
     */
    public BookingStatus getStatus()
    {
        return this.status;
    }

}
