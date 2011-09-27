/*
 * Created on 2011-9-27
 */

package com.ehealth.eyedpt.dal.entities.enums;

/**
 * @author emac
 */
public enum BookingStatus
{

    ACCEPTED("������"), CANCELED("ȡ��"), COMPLETED("���"), BROKEN("ˬԼ");

    private String label;

    private BookingStatus(String label)
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
