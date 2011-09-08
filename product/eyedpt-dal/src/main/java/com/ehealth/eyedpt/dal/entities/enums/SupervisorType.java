/*
 * Created on 2011-9-8
 */

package com.ehealth.eyedpt.dal.entities.enums;

/**
 * @author emac
 */
public enum SupervisorType
{

    DOCTOR("博士研究生导师"), MASTER("硕士研究生导师"), NOPE("暂不是导师");

    private String label;

    private SupervisorType(String label)
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
