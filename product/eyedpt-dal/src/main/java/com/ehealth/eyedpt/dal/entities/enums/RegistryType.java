/*
 * Created on 2011-8-7
 */

package com.ehealth.eyedpt.dal.entities.enums;

/**
 * Enumerates all supported registry types of patients.
 * 
 * @author emac
 */
public enum RegistryType
{

    ID("身份证"), MEDICARE("医保卡");

    private String label;

    private RegistryType(String label)
    {
        this.label = label;
    }

    public String getLabel()
    {
        return this.label;
    }

}
