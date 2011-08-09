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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author emac
 */
@Entity(name = "doctorservice")
@Table(name = "doctorservice")
@NamedQueries(
{ @NamedQuery(name = DoctorService.QUERY_FIND_ALL, query = "select d from doctorservice d")})
public class DoctorService
{

    public static final String QUERY_FIND_ALL = "FindAllDoctorServices"; //$NON-NLS-1$

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long               id;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @Column(name = "hospitalid", nullable = false)
    @NotNull
    private Hospital           hospital;

    @Column
    private boolean            acceptbooking;

    @Column(nullable = false)
    @NotNull
    @Min(0)
    private float              bookingprice;

    @Column
    private boolean            acceptconsulting;

    @Column(nullable = false)
    @NotNull
    @Min(0)
    private float              consultingprice;

    @Column
    private boolean            acceptquestion;

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
     * @return the hospital
     */
    public Hospital getHospital()
    {
        return hospital;
    }

    /**
     * @param hospital the hospital to set
     */
    public void setHospital(Hospital hospital)
    {
        this.hospital = hospital;
    }

    /**
     * @return the acceptbooking
     */
    public boolean isAcceptbooking()
    {
        return acceptbooking;
    }

    /**
     * @param acceptbooking the acceptbooking to set
     */
    public void setAcceptbooking(boolean acceptbooking)
    {
        this.acceptbooking = acceptbooking;
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
     * @return the acceptconsulting
     */
    public boolean isAcceptconsulting()
    {
        return acceptconsulting;
    }

    /**
     * @param acceptconsulting the acceptconsulting to set
     */
    public void setAcceptconsulting(boolean acceptconsulting)
    {
        this.acceptconsulting = acceptconsulting;
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

    /**
     * @return the acceptquestion
     */
    public boolean isAcceptquestion()
    {
        return acceptquestion;
    }

    /**
     * @param acceptquestion the acceptquestion to set
     */
    public void setAcceptquestion(boolean acceptquestion)
    {
        this.acceptquestion = acceptquestion;
    }

}
