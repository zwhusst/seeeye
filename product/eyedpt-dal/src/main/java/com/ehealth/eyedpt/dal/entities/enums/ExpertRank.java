/*
 * Created on 2011-9-8
 */

package com.ehealth.eyedpt.dal.entities.enums;

/**
 * @author emac
 */
public enum ExpertRank
{

    VIP("特需专家"), GENERAL("普通专家");

    private String label;

    private ExpertRank(String label)
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
