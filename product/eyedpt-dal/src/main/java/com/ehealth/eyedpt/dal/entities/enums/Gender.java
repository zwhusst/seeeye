/*
 * Created on 2011-8-7
 */

package com.ehealth.eyedpt.dal.entities.enums;

/**
 * @author emac
 */
public enum Gender
{

    M("��"), F("Ů");

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
