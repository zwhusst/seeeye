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

    ID("���֤"), MEDICARE("ҽ����");

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
