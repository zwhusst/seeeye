/*
 * Created on 2011-8-21
 */

package com.ehealth.eyedpt.mvc.form.models;

import javax.validation.constraints.Size;

/**
 * @author emac
 */
public class UserBean
{

    @Size(min = 2, max = 16)
    private String name;

    @Size(min = 6, max = 16)
    private String password;

    /**
     * @return the name
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the password
     */
    public String getPassword()
    {
        return this.password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

}
