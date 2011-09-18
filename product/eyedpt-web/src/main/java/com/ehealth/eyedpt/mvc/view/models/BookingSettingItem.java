/*
 * Created on 2011-9-18
 */

package com.ehealth.eyedpt.mvc.view.models;

import com.ehealth.eyedpt.dal.entities.enums.ExpertRank;

/**
 * @author emac
 */
public class BookingSettingItem
{

    private String     realname;
    private String     employeeid;
    private ExpertRank expertrank;
    private String     servicetime;
    private boolean    active;

    public BookingSettingItem(String realname, String employeeid, ExpertRank expertrank, String servicetime,
            boolean active)
    {
        this.realname = realname;
        this.employeeid = employeeid;
        this.expertrank = expertrank;
        this.servicetime = servicetime;
        this.active = active;
    }

    /**
     * @return the realname
     */
    public String getRealname()
    {
        return this.realname;
    }

    /**
     * @return the employeeid
     */
    public String getEmployeeid()
    {
        return this.employeeid;
    }

    /**
     * @return the expertrank
     */
    public ExpertRank getExpertrank()
    {
        return this.expertrank;
    }

    /**
     * @return the servicetime
     */
    public String getServicetime()
    {
        return this.servicetime;
    }

    /**
     * @return the active
     */
    public boolean isActive()
    {
        return this.active;
    }

}
