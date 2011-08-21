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
     * ����ҽʦ
     */
    PROFESSOR("����ҽʦ"),
    /**
     * ������ҽʦ
     */
    ASSOCIATE_PROFESSOR("������ҽʦ"),
    /**
     * ����ҽʦ
     */
    DOCOTR_IN_CHARGE("����ҽʦ"),
    /**
     * סԺҽʦ
     */
    RESIDENT_DOCTOR("סԺҽʦ"),
    /**
     * ʵϰҽʦ
     */
    INTERN("ʵϰҽʦ"),
    /**
     * ��ϰҽʦ
     */
    PRACTICE_INTERN("��ϰҽʦ");

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
