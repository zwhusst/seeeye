/*
 * Created on 2011-9-18
 */

package com.ehealth.eyedpt.dal.entities;

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

import com.ehealth.eyedpt.dal.entities.enums.TimeSlot;
import com.ehealth.eyedpt.dal.entities.enums.Weekday;

/**
 * @author emac
 */
@Entity(name = "bookingroster")
@Table(name = "bookingroster")
@NamedQueries(
{
        @NamedQuery(name = BookingRoster.QUERY_FIND_ALL, query = "select r from bookingroster r"),
        @NamedQuery(name = BookingRoster.QUERY_FIND_BY_DOCTOR, query = "select r from bookingroster r where r.doctor=:doctor")})
public class BookingRoster
{

    public static final String QUERY_FIND_ALL       = "FindAllBookingRosters";
    public static final String QUERY_FIND_BY_DOCTOR = "FindBookingRostersByDoctor";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long               id;

    @ManyToOne(optional = false, cascade =
    { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @Column(name = "doctorid", nullable = false)
    private Doctor             doctor;

    @Column(nullable = false, columnDefinition = "TINYINT")
    private int                capability;

    @Column(nullable = false)
    private Weekday            dayofweek;

    @Column(nullable = false)
    private TimeSlot           timeslot;

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
     * @return the capability
     */
    public int getCapability()
    {
        return this.capability;
    }

    /**
     * @param capability the capability to set
     */
    public void setCapability(int capability)
    {
        this.capability = capability;
    }

    /**
     * @return the dayofweek
     */
    public Weekday getDayofweek()
    {
        return this.dayofweek;
    }

    /**
     * @param dayofweek the dayofweek to set
     */
    public void setDayofweek(Weekday dayofweek)
    {
        this.dayofweek = dayofweek;
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

}
