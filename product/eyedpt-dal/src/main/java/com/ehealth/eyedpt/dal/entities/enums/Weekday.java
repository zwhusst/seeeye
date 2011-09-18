/*
 * Created on 2011-9-18
 */

package com.ehealth.eyedpt.dal.entities.enums;

/**
 * @author emac
 */
public enum Weekday
{

    MON("周一"), TUE("周二"), WED("周三"), THU("周四"), FRI("周五");

    private String label;

    private Weekday(String label)
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
