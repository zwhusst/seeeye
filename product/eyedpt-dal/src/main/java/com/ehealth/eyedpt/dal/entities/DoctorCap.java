/*
 * Created on 2011-8-7
 */

package com.ehealth.eyedpt.dal.entities;

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
@Entity(name = "doctorcap")
@Table(name = "doctorcap")
@NamedQueries(
{ @NamedQuery(name = DoctorCap.QUERY_FIND_ALL, query = "select c from doctorcap c"),
        @NamedQuery(name = DoctorCap.QUERY_FIND_BY_DOCTOR, query = "select c from doctorcap c where c.doctor=:doctor")})
public class DoctorCap
{

    public static final String QUERY_FIND_ALL       = "FindAllDoctorCaps";
    public static final String QUERY_FIND_BY_DOCTOR = "FindDoctorCapByDoctor";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long               id;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @Column(name = "doctorid", nullable = false)
    private Doctor             doctor;

    @Column
    private boolean            acceptbookings;

    @Column
    private float              bookingprice;

    @Column
    private boolean            acceptconsultings;

    @Column
    private float              consultingprice;

    @Column
    private boolean            acceptquestions;

    /**
     * @return the id
     */
    public long getId()
    {
        return id;
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
     * @return the acceptbookings
     */
    public boolean isAcceptbookings()
    {
        return this.acceptbookings;
    }

    /**
     * @param acceptbookings the acceptbookings to set
     */
    public void setAcceptbookings(boolean acceptbookings)
    {
        this.acceptbookings = acceptbookings;
    }

    /**
     * @return the acceptconsultings
     */
    public boolean isAcceptconsultings()
    {
        return this.acceptconsultings;
    }

    /**
     * @param acceptconsultings the acceptconsultings to set
     */
    public void setAcceptconsultings(boolean acceptconsultings)
    {
        this.acceptconsultings = acceptconsultings;
    }

    /**
     * @return the acceptquestions
     */
    public boolean isAcceptquestions()
    {
        return this.acceptquestions;
    }

    /**
     * @param acceptquestions the acceptquestions to set
     */
    public void setAcceptquestions(boolean acceptquestions)
    {
        this.acceptquestions = acceptquestions;
    }

    /**
     * @return the bookingprice
     */
    public float getBookingprice()
    {
        return bookingprice;
    }

    /**
     * @param bookingprice the bookingprice to set
     */
    public void setBookingprice(float bookingprice)
    {
        this.bookingprice = bookingprice;
    }

    /**
     * @return the consultingprice
     */
    public float getConsultingprice()
    {
        return consultingprice;
    }

    /**
     * @param consultingprice the consultingprice to set
     */
    public void setConsultingprice(float consultingprice)
    {
        this.consultingprice = consultingprice;
    }

}
