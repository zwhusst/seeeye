/*
 * Created on 2011-9-25
 */

package com.ehealth.eyedpt.mvc.json;

import java.util.Date;

/**
 * JSON representation of {@code BookingEx} entity.
 * 
 * @author emac
 */
public class BookingExStatus
{

    private Date startDate;

    private Date endDate;

    /**
     * @param startDate
     * @param endDate
     */
    public BookingExStatus(Date startDate, Date endDate)
    {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate()
    {
        return this.startDate;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate()
    {
        return this.endDate;
    }

}
