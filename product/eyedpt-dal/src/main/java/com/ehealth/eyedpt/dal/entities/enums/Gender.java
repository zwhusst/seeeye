/*
 * Created on 2011-8-7
 */

package com.ehealth.eyedpt.dal.entities.enums;

/**
 * @author emac
 */
public enum Gender
{

    M("ÄÐ"), F("Å®");

    private String label;

    private Gender(String label)
    {
        this.label = label;
    }

    public String getLabel()
    {
        return this.label;
    }

}
