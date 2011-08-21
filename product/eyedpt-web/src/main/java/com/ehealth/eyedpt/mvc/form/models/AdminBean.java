/*
 * Created on 2011-8-20
 */

package com.ehealth.eyedpt.mvc.form.models;

import javax.validation.constraints.Size;

import org.apache.bval.constraints.Email;
import org.apache.bval.constraints.NotEmpty;

import com.ehealth.eyedpt.dal.entities.Admin;

/**
 * @author emac
 */
public class AdminBean
{

    @Size(min = 2, max = 16)
    private String   name;

    @Size(min = 6, max = 16)
    private String   password;

    @NotEmpty
    @Email
    @Size(max = 64)
    private String   email;

    @Size(min = 1, max = 32)
    private String[] roleset;

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

    /**
     * @return the email
     */
    public String getEmail()
    {
        return this.email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * @return the roleset
     */
    public String[] getRoleset()
    {
        return this.roleset;
    }

    /**
     * @param roleset the roleset to set
     */
    public void setRoleset(String[] roleset)
    {
        this.roleset = roleset;
    }

    /**
     * @param admin
     * @return
     */
    public static AdminBean fromEntity(Admin admin)
    {
        AdminBean bean = new AdminBean();
        bean.setName(admin.getUser().getName());
        bean.setPassword(admin.getUser().getPassword());
        bean.setEmail(admin.getEmail());

        return bean;
    }

}
