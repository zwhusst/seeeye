/*
 * Created on 2011-9-25
 */

package com.ehealth.eyedpt.dal.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author emac
 */
@Entity(name = "bookingex")
@Table(name = "bookingex")
@NamedQueries(
{ @NamedQuery(name = BookingEx.QUERY_FIND_ALL, query = "select e from bookingex e"),
        @NamedQuery(name = BookingEx.QUERY_FIND_BY_DOCTOR, query = "select e from bookingex e where e.doctor=:doctor")})
public class BookingEx
{

    public static final String QUERY_FIND_ALL       = "FindAllBookingExs";
    public static final String QUERY_FIND_BY_DOCTOR = "FindBookingExByDoctor";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long               id;

    @OneToOne(optional = false, cascade =
    { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @Column(name = "doctorid", nullable = false)
    private Doctor             doctor;

    @Column(nullable = false)
    private Date               startdate;

    @Column(nullable = false)
    private Date               enddate;

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
     * @return the startdate
     */
    public Date getStartdate()
    {
        return this.startdate;
    }

    /**
     * @param startdate the startdate to set
     */
    public void setStartdate(Date startdate)
    {
        this.startdate = startdate;
    }

    /**
     * @return the enddate
     */
    public Date getEnddate()
    {
        return this.enddate;
    }

    /**
     * @param enddate the enddate to set
     */
    public void setEnddate(Date enddate)
    {
        this.enddate = enddate;
    }

}
