/*
 * Created on 2011-8-9
 */

package com.ehealth.eyedpt.mvc.view.models;

/**
 * Stands for an item in user panel.
 * 
 * @author emac
 */
public class UserPanelItem
{

    private String name;
    private String href;

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the href
     */
    public String getHref()
    {
        return href;
    }

    /**
     * @param href the href to set
     */
    public void setHref(String href)
    {
        this.href = href;
    }

}
