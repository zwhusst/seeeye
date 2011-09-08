/*
 * Created on 2011-9-8
 */

package com.ehealth.eyedpt.dal.entities.enums;

/**
 * @author emac
 */
public enum SupervisorType
{

    DOCTOR("��ʿ�о�����ʦ"), MASTER("˶ʿ�о�����ʦ"), NOPE("�ݲ��ǵ�ʦ");

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
