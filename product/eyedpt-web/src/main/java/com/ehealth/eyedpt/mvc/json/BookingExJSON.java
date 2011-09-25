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
public class BookingExJSON
{

    private Date startDate;

    private Date endDate;

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

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }

}
