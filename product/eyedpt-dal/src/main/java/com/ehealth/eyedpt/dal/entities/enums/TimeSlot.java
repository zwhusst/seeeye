/*
 * Created on 2011-9-18
 */

package com.ehealth.eyedpt.dal.entities.enums;

/**
 * @author emac
 */
public enum TimeSlot
{

    AM("ионГ"), PM("обнГ");

    private String label;

    private TimeSlot(String label)
    {
        this.label = label;
    }

    public String getLabel()
    {
        return this.label;
    }

    public String getName()
    {
        return name();
    }

}
