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
     * @param name
     * @param href
     */
    public UserPanelItem(String name, String href)
    {
        this.name = name;
        this.href = href;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return the href
     */
    public String getHref()
    {
        return href;
    }

}
