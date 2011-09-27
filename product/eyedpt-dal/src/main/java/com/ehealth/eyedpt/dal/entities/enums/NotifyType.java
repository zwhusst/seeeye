/*
 * Created on 2011-9-27
 */

package com.ehealth.eyedpt.dal.entities.enums;

/**
 * @author emac
 */
public enum NotifyType
{

    EMAIL("邮件通知"), SMS("短信通知");

    private String label;

    private NotifyType(String label)
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
