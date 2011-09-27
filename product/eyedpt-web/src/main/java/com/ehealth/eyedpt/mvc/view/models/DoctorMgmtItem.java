/*
 * Created on 2011-8-21
 */

package com.ehealth.eyedpt.mvc.view.models;

import com.ehealth.eyedpt.dal.entities.enums.DoctorAdminTitle;
import com.ehealth.eyedpt.dal.entities.enums.DoctorTitle;
import com.ehealth.eyedpt.dal.entities.enums.ExpertRank;
import com.ehealth.eyedpt.dal.entities.enums.Gender;
import com.ehealth.eyedpt.dal.entities.enums.SupervisorType;

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
    private ExpertRank       expertrank;
    private SupervisorType   supervisortype;

    /**
     * @param name
     * @param realname
     * @param gender
     * @param employeeid
     * @param title
     * @param admintitle
     * @param expertrank
     * @param supervisortype
     */
    public DoctorMgmtItem(String name, String realname, Gender gender, String employeeid, DoctorTitle title,
            DoctorAdminTitle admintitle, ExpertRank expertrank, SupervisorType supervisortype)
    {
        this.name = name;
        this.realname = realname;
        this.gender = gender;
        this.employeeid = employeeid;
        this.title = title;
        this.admintitle = admintitle;
        this.expertrank = expertrank;
        this.supervisortype = supervisortype;
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

    /**
     * @return the expertrank
     */
    public ExpertRank getExpertrank()
    {
        return this.expertrank;
    }

    /**
     * @return the supervisortype
     */
    public SupervisorType getSupervisortype()
    {
        return this.supervisortype;
    }

}
