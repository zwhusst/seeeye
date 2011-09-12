/*
 * Created on 2011-9-12
 */

package com.ehealth.eyedpt.mvc.form.models;

import javax.validation.constraints.Size;

/**
 * @author emac
 */
public class ForgotPwdBean
{

    @Size(min = 2, max = 16)
    private String name;

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

}
