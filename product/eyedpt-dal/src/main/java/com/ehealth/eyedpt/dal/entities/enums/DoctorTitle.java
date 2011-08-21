/*
 * Created on 2011-8-21
 */

package com.ehealth.eyedpt.dal.entities.enums;

/**
 * @author emac
 */
public enum DoctorTitle
{

    /**
     * 主任医师
     */
    PROFESSOR("主任医师"),
    /**
     * 副主任医师
     */
    ASSOCIATE_PROFESSOR("副主任医师"),
    /**
     * 主治医师
     */
    DOCOTR_IN_CHARGE("主治医师"),
    /**
     * 住院医师
     */
    RESIDENT_DOCTOR("住院医师"),
    /**
     * 实习医师
     */
    INTERN("实习医师"),
    /**
     * 见习医师
     */
    PRACTICE_INTERN("见习医师");

    private String label;

    private DoctorTitle(String label)
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
