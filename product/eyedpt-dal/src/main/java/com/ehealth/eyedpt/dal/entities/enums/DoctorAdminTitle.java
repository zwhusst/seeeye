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
     * ��������
     */
    KSZR("��������"),
    /**
     * ���Ҹ�����
     */
    KSFZR("���Ҹ�����"),
    /**
     * ��������
     */
    MZZR("��������"),
    /**
     * ��������
     */
    BQZR("��������"),
    /**
     * ҽ�Ƹ���
     */
    YLGS("ҽ�Ƹ���"),
    /**
     * ����������
     */
    KYSZR("����������"),
    /**
     * �����Ҹ�����
     */
    KYSFZR("�����Ҹ�����"),
    /**
     * סԺҽʦ����
     */
    ZYYSDJ("סԺҽʦ����"),
    /**
     * ʵϰҽʦ����
     */
    SXYSDJ("ʵϰҽʦ����");

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
