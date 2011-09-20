/*
 * Created on 2011-9-20
 */

package com.ehealth.eyedpt.mvc.view.models;

import com.ehealth.eyedpt.dal.entities.enums.TimeSlot;
import com.ehealth.eyedpt.dal.entities.enums.Weekday;

/**
 * @author emac
 */
public class BookingRosterItem
{

    private Weekday  dayofweek;

    private TimeSlot timeslot;

    private int      capability;

    public BookingRosterItem(Weekday dayofweek, TimeSlot timeslot, int capability)
    {
        this.dayofweek = dayofweek;
        this.timeslot = timeslot;
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
     * @return the timeslot
     */
    public TimeSlot getTimeslot()
    {
        return this.timeslot;
    }

    /**
     * @return the capability
     */
    public int getCapability()
    {
        return this.capability;
    }

}
