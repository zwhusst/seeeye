/*
 * Created on 2011-8-10
 */

package com.ehealth.eyedpt.mvc.form.models;

import java.sql.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.bval.constraints.Email;
import org.apache.bval.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.ehealth.eyedpt.dal.entities.Patient;
import com.ehealth.eyedpt.dal.entities.enums.Gender;
import com.ehealth.eyedpt.dal.entities.enums.RegistryType;

/**
 * @author emac
 */
public class PatientBean extends UserBean
{

    @Size(min = 2, max = 32)
    private String       realname;

    @NotNull
    private Gender       gender       = Gender.M;

    @DateTimeFormat(iso = ISO.DATE)
    @Past
    private Date         birthday;

    @Min(1)
    @Max(99)
    private int          age;

    @NotEmpty
    @Size(max = 32)
    private String       province;

    @NotEmpty
    @Size(max = 32)
    private String       city;

    @NotNull
    private RegistryType registrytype = RegistryType.ID;

    @NotEmpty
    @Size(max = 32)
    private String       registryno;

    @NotEmpty
    @Email
    @Size(max = 64)
    private String       email;

    @Pattern(regexp = "\\d{11}")
    private String       cellphone;

    @Size(max = 32)
    private String       telephone;

    @Size(max = 32)
    private String       faxno;

    /**
     * @return the realname
     */
    public String getRealname()
    {
        return this.realname;
    }

    /**
     * @param realname the realname to set
     */
    public void setRealname(String realname)
    {
        this.realname = realname;
    }

    /**
     * @return the birthday
     */
    public Date getBirthday()
    {
        return this.birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

    /**
     * @return the age
     */
    public int getAge()
    {
        return this.age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age)
    {
        this.age = age;
    }

    /**
     * @return the gender
     */
    public Gender getGender()
    {
        return this.gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(Gender gender)
    {
        this.gender = gender;
    }

    /**
     * @return the province
     */
    public String getProvince()
    {
        return this.province;
    }

    /**
     * @param province the province to set
     */
    public void setProvince(String province)
    {
        this.province = province;
    }

    /**
     * @return the city
     */
    public String getCity()
    {
        return this.city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city)
    {
        this.city = city;
    }

    /**
     * @return the registrytype
     */
    public RegistryType getRegistrytype()
    {
        return this.registrytype;
    }

    /**
     * @param registrytype the registrytype to set
     */
    public void setRegistrytype(RegistryType registrytype)
    {
        this.registrytype = registrytype;
    }

    /**
     * @return the registryno
     */
    public String getRegistryno()
    {
        return this.registryno;
    }

    /**
     * @param registryno the registryno to set
     */
    public void setRegistryno(String registryno)
    {
        this.registryno = registryno;
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
     * @return the cellphone
     */
    public String getCellphone()
    {
        return this.cellphone;
    }

    /**
     * @param cellphone the cellphone to set
     */
    public void setCellphone(String cellphone)
    {
        this.cellphone = cellphone;
    }

    /**
     * @return the telephone
     */
    public String getTelephone()
    {
        return this.telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    /**
     * @return the faxno
     */
    public String getFaxno()
    {
        return this.faxno;
    }

    /**
     * @param faxno the faxno to set
     */
    public void setFaxno(String faxno)
    {
        this.faxno = faxno;
    }

    /**
     * @param patient
     * @return
     */
    public static PatientBean fromEntity(Patient patient)
    {
        PatientBean bean = new PatientBean();
        bean.setName(patient.getUser().getName());
        bean.setPassword(patient.getUser().getPassword());
        bean.setRealname(patient.getRealname());
        bean.setGender(patient.getGender());
        bean.setBirthday(patient.getBirthday());
        bean.setAge(patient.getAge());
        bean.setProvince(patient.getProvince());
        bean.setCity(patient.getCity());
        bean.setRegistrytype(patient.getRegistrytype());
        bean.setRegistryno(patient.getRegistryno());
        bean.setEmail(patient.getEmail());
        bean.setCellphone(patient.getCellphone());
        bean.setTelephone(patient.getTelephone());
        bean.setFaxno(patient.getFaxno());

        return bean;
    }

}
