/*
 * Created on 2011-8-21
 */

package com.ehealth.eyedpt.mvc.view.models;

import com.ehealth.eyedpt.dal.entities.enums.DoctorAdminTitle;
import com.ehealth.eyedpt.dal.entities.enums.DoctorTitle;
import com.ehealth.eyedpt.dal.entities.enums.Gender;

/**
 * @author emac
 */
public class DoctorMgmtItem
{

    private String           name;
    private String           realname;
    private Gender           gender;
    private String           employeeid;
    private DoctorTitle      title;
    private DoctorAdminTitle admintitle;

    /**
     * @param name
     * @param realname
     * @param gender
     * @param employeeid
     * @param title
     * @param admintitle
     */
    public DoctorMgmtItem(String name, String realname, Gender gender, String employeeid, DoctorTitle title,
            DoctorAdminTitle admintitle)
    {
        this.name = name;
        this.realname = realname;
        this.gender = gender;
        this.employeeid = employeeid;
        this.title = title;
        this.admintitle = admintitle;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return the realname
     */
    public String getRealname()
    {
        return this.realname;
    }

    /**
     * @return the gender
     */
    public Gender getGender()
    {
        return this.gender;
    }

    /**
     * @return the title
     */
    public DoctorTitle getTitle()
    {
        return this.title;
    }

    /**
     * @return the admintitle
     */
    public DoctorAdminTitle getAdmintitle()
    {
        return this.admintitle;
    }

    /**
     * @return the employeeid
     */
    public String getEmployeeid()
    {
        return this.employeeid;
    }

}
