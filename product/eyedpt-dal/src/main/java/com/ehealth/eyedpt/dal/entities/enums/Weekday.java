/*
 * Created on 2011-9-18
 */

package com.ehealth.eyedpt.dal.entities.enums;

/**
 * @author emac
 */
public enum Weekday
{

    MON("��һ"), TUE("�ܶ�"), WED("����"), THU("����"), FRI("����");

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
