/*
 * Created on 2011-8-21
 */

package com.ehealth.eyedpt.dal.entities.enums;

/**
 * @author emac
 */
public enum DoctorAdminTitle
{

    /**
     * 科室主任
     */
    KSZR("科室主任"),
    /**
     * 科室副主任
     */
    KSFZR("科室副主任"),
    /**
     * 门诊主任
     */
    MZZR("门诊主任"),
    /**
     * 病区主任
     */
    BQZR("病区主任"),
    /**
     * 医疗干事
     */
    YLGS("医疗干事"),
    /**
     * 科研室主任
     */
    KYSZR("科研室主任"),
    /**
     * 科研室副主任
     */
    KYSFZR("科研室副主任"),
    /**
     * 住院医师带教
     */
    ZYYSDJ("住院医师带教"),
    /**
     * 实习医师带教
     */
    SXYSDJ("实习医师带教");

    private String label;

    private DoctorAdminTitle(String label)
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
