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
    private String newPassword1;

    @Size(min = 6, max = 16)
    private String newPassword2;

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
     * @return the newPassword1
     */
    public String getNewPassword1()
    {
        return this.newPassword1;
    }

    /**
     * @param newPassword1 the newPassword1 to set
     */
    public void setNewPassword1(String newPassword1)
    {
        this.newPassword1 = newPassword1;
    }

    /**
     * @return the newPassword2
     */
    public String getNewPassword2()
    {
        return this.newPassword2;
    }

    /**
     * @param newPassword2 the newPassword2 to set
     */
    public void setNewPassword2(String newPassword2)
    {
        this.newPassword2 = newPassword2;
    }

}
