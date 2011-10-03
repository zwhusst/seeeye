/*
 * Created on 2011-9-27
 */

package com.ehealth.eyedpt.dal.entities;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.ehealth.eyedpt.dal.entities.enums.BookingStatus;
import com.ehealth.eyedpt.dal.entities.enums.NotifyType;
import com.ehealth.eyedpt.dal.entities.enums.TimeSlot;

/**
 * @author emac
 */
@Entity(name = "booking")
@Table(name = "booking")
@NamedQueries(
{
        @NamedQuery(name = Booking.QUERY_FIND_ALL, query = "select b from booking b"),
        @NamedQuery(name = Booking.QUERY_FIND_BY_BOOKING_ID, query = "select b from booking b where b.bookingid=:bookingid"),
        @NamedQuery(name = Booking.QUERY_FIND_BY_PATIENT, query = "select b from booking b where b.patient=:patient"),
        @NamedQuery(name = Booking.QUERY_FIND_BY_STATUS, query = "select b from booking b where b.status=:status")})
public class Booking
{

    public static final String QUERY_FIND_ALL           = "FindAllBookings";
    public static final String QUERY_FIND_BY_BOOKING_ID = "FindBookingsByBookingId";
    public static final String QUERY_FIND_BY_PATIENT    = "FindBookingsByPatient";
    public static final String QUERY_FIND_BY_STATUS     = "FindBookingsByStatus";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long               id;

    @Column(nullable = false)
    private long               bookingid;

    @ManyToOne(optional = false, cascade =
    { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @Column(name = "patientid", nullable = false)
    private Patient            patient;

    @ManyToOne(optional = false, cascade =
    { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @Column(name = "doctorid", nullable = false)
    private Doctor             doctor;

    @Column(nullable = false)
    private Timestamp          postdate;

    @Column(nullable = false)
    private Date               bookingdate;

    @Column(nullable = false)
    private TimeSlot           timeslot;

    @Column(nullable = false)
    private BookingStatus      status;

    @Column(nullable = false)
    private NotifyType         notifytype;

    @Column(nullable = false)
    private boolean            notified;

    @Column
    private Timestamp          notifytime;

    /**
     * @return the id
     */
    public long getId()
    {
        return this.id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id)
    {
        this.id = id;
    }

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
     * @return the patient
     */
    public Patient getPatient()
    {
        return this.patient;
    }

    /**
     * @param patient the patient to set
     */
    public void setPatient(Patient patient)
    {
        this.patient = patient;
    }

    /**
     * @return the doctor
     */
    public Doctor getDoctor()
    {
        return this.doctor;
    }

    /**
     * @param doctor the doctor to set
     */
    public void setDoctor(Doctor doctor)
    {
        this.doctor = doctor;
    }

    /**
     * @return the postdate
     */
    public Timestamp getPostdate()
    {
        return this.postdate;
    }

    /**
     * @param postdate the postdate to set
     */
    public void setPostdate(Timestamp postdate)
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
     * @return the notified
     */
    public boolean isNotified()
    {
        return this.notified;
    }

    /**
     * @param notified the notified to set
     */
    public void setNotified(boolean notified)
    {
        this.notified = notified;
    }

    /**
     * @return the notifytime
     */
    public Timestamp getNotifytime()
    {
        return this.notifytime;
    }

    /**
     * @param notifytime the notifytime to set
     */
    public void setNotifytime(Timestamp notifytime)
    {
        this.notifytime = notifytime;
    }

}
