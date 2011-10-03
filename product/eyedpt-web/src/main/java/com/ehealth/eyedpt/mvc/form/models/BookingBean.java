/*
 * Created on 2011-10-3
 */

package com.ehealth.eyedpt.mvc.form.models;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.apache.bval.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.ehealth.eyedpt.dal.entities.Booking;
import com.ehealth.eyedpt.dal.entities.enums.BookingStatus;
import com.ehealth.eyedpt.dal.entities.enums.NotifyType;
import com.ehealth.eyedpt.dal.entities.enums.TimeSlot;

/**
 * @author emac
 */
public class BookingBean
{

    @Pattern(regexp = "\\d{10}")
    private long          bookingid;

    @NotEmpty
    private String        patientname;

    @NotEmpty
    private String        doctorname;

    @NotNull
    @DateTimeFormat(iso = ISO.DATE)
    @Past
    private Date          postdate;

    @NotNull
    @DateTimeFormat(iso = ISO.DATE)
    private Date          bookingdate;

    @NotNull
    private TimeSlot      timeslot   = TimeSlot.AM;

    @NotNull
    private BookingStatus status;

    @NotNull
    private NotifyType    notifytype = NotifyType.SMS;

    @DateTimeFormat(iso = ISO.DATE)
    @Past
    private Date          notifytime;

    /**
     * @return the bookingid
     */
    public long getBookingid()
    {
        return this.bookingid;
    }

    /**
     * @param bookingid the bookingid to set
     */
    public void setBookingid(long bookingid)
    {
        this.bookingid = bookingid;
    }

    /**
     * @return the patientname
     */
    public String getPatientname()
    {
        return this.patientname;
    }

    /**
     * @param patientname the patientname to set
     */
    public void setPatientname(String patientname)
    {
        this.patientname = patientname;
    }

    /**
     * @return the doctorname
     */
    public String getDoctorname()
    {
        return this.doctorname;
    }

    /**
     * @param doctorname the doctorname to set
     */
    public void setDoctorname(String doctorname)
    {
        this.doctorname = doctorname;
    }

    /**
     * @return the postdate
     */
    public Date getPostdate()
    {
        return this.postdate;
    }

    /**
     * @param postdate the postdate to set
     */
    public void setPostdate(Date postdate)
    {
        this.postdate = postdate;
    }

    /**
     * @return the bookingdate
     */
    public Date getBookingdate()
    {
        return this.bookingdate;
    }

    /**
     * @param bookingdate the bookingdate to set
     */
    public void setBookingdate(Date bookingdate)
    {
        this.bookingdate = bookingdate;
    }

    /**
     * @return the timeslot
     */
    public TimeSlot getTimeslot()
    {
        return this.timeslot;
    }

    /**
     * @param timeslot the timeslot to set
     */
    public void setTimeslot(TimeSlot timeslot)
    {
        this.timeslot = timeslot;
    }

    /**
     * @return the status
     */
    public BookingStatus getStatus()
    {
        return this.status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(BookingStatus status)
    {
        this.status = status;
    }

    /**
     * @return the notifytype
     */
    public NotifyType getNotifytype()
    {
        return this.notifytype;
    }

    /**
     * @param notifytype the notifytype to set
     */
    public void setNotifytype(NotifyType notifytype)
    {
        this.notifytype = notifytype;
    }

    /**
     * @return the notifytime
     */
    public Date getNotifytime()
    {
        return this.notifytime;
    }

    /**
     * @param notifytime the notifytime to set
     */
    public void setNotifytime(Date notifytime)
    {
        this.notifytime = notifytime;
    }

    /**
     * @param booking
     * @return
     */
    public static BookingBean fromEntity(Booking booking)
    {
        BookingBean bean = new BookingBean();
        bean.setBookingid(booking.getBookingid());
        bean.setPatientname(booking.getPatient().getUser().getName());
        bean.setDoctorname(booking.getDoctor().getUser().getName());
        bean.setPostdate(booking.getPostdate());
        bean.setBookingdate(booking.getBookingdate());
        bean.setTimeslot(booking.getTimeslot());
        bean.setStatus(booking.getStatus());
        bean.setNotifytype(booking.getNotifytype());
        bean.setNotifytime(booking.getNotifytime());

        return bean;
    }

}
