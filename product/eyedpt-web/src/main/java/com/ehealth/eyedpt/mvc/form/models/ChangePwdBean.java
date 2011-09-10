/*
 * Created on 2011-8-22
 */

package com.ehealth.eyedpt.mvc.form.models;

import javax.validation.constraints.Size;

import org.apache.bval.constraints.NotEmpty;

/**
 * @author emac
 */
public class ChangePwdBean
{

    @NotEmpty
    private String password;

    @Size(min = 6, max = 16)
    private String newPassword;

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

    /**
     * @return the newPassword
     */
    public String getNewPassword()
    {
        return this.newPassword;
    }

    /**
     * @param newPassword the newPassword to set
     */
    public void setNewPassword(String newPassword)
    {
        this.newPassword = newPassword;
    }

}
