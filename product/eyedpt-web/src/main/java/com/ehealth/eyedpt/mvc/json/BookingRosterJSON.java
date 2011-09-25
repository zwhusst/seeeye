/*
 * Created on 2011-9-25
 */

package com.ehealth.eyedpt.mvc.json;

import com.ehealth.eyedpt.dal.entities.enums.TimeSlot;
import com.ehealth.eyedpt.dal.entities.enums.Weekday;

/**
 * JSON representation of {@code BookingRoster} entity.
 * 
 * @author emac
 */
public class BookingRosterJSON
{

    private Weekday  dayOfWeek;
    private TimeSlot timeSlot;
    private int      capability;

    /**
     * @return the dayOfWeek
     */
    public Weekday getDayOfWeek()
    {
        return this.dayOfWeek;
    }

    /**
     * @param dayOfWeek the dayOfWeek to set
     */
    public void setDayOfWeek(Weekday dayOfWeek)
    {
        this.dayOfWeek = dayOfWeek;
    }

    /**
     * @return the timeSlot
     */
    public TimeSlot getTimeSlot()
    {
        return this.timeSlot;
    }

    /**
     * @param timeSlot the timeSlot to set
     */
    public void setTimeSlot(TimeSlot timeSlot)
    {
        this.timeSlot = timeSlot;
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

    @Override
    public boolean equals(Object obj)
    {
        if ( obj == this )
        {
            return true;
        }

        if ( !(obj instanceof BookingRosterJSON) )
        {
            return false;
        }

        BookingRosterJSON json = (BookingRosterJSON) obj;

        return json.getDayOfWeek() == this.dayOfWeek && json.getTimeSlot() == this.timeSlot
                && json.getCapability() == this.capability;
    }

    @Override
    public int hashCode()
    {
        int result = 17;
        if ( this.dayOfWeek != null )
        {
            result = 31 * result + this.dayOfWeek.name().hashCode();
        }
        if ( this.timeSlot != null )
        {
            result *= 31 * result + this.timeSlot.name().hashCode();
        }
        result *= 31 * result + this.capability;

        return result;
    }

}
