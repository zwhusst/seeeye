/*
 * Created on 2011-8-7
 */

package com.ehealth.eyedpt.dal.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.ehealth.eyedpt.dal.entities.enums.Gender;
import com.ehealth.eyedpt.dal.entities.enums.RegistryType;

/**
 * @author emac
 */
@Entity(name = "patient")
@Table(name = "patient")
@NamedQueries(
{ @NamedQuery(name = Patient.QUERY_FIND_ALL, query = "select p from patient p")})
public class Patient
{

    public static final String QUERY_FIND_ALL = "FindAllPatients";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long               id;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @Column(name = "userid", nullable = false)
    @NotNull
    private User               user;

    @Column(nullable = false, length = 32)
    @NotNull
    @Size(max = 32)
    private String             realname;

    @Column
    private Date               birthday;

    @Column(nullable = false, columnDefinition = "TINYINT")
    @NotNull
    @Min(1)
    @Max(99)
    private int                age;

    @Column(nullable = false)
    @NotNull
    private Gender             gender;

    @Column(nullable = false, length = 32)
    @NotNull
    @Size(max = 32)
    private String             province;

    @Column(nullable = false, length = 32)
    @NotNull
    @Size(max = 32)
    private String             city;

    @Column(nullable = false)
    @NotNull
    private RegistryType       registrytype;

    @Column(nullable = false, length = 32)
    @NotNull
    @Size(max = 32)
    private String             registryno;

    @Column(nullable = false, length = 64)
    @NotNull
    @Size(max = 64)
    private String             email;

    @Column(nullable = false, length = 11)
    @NotNull
    @Size(min = 11, max = 11)
    private String             cellphone;

    @Column(length = 32)
    @Size(max = 32)
    private String             telephone;

    @Column(length = 32)
    @Size(max = 32)
    private String             faxno;

    /**
     * @return the id
     */
    public long getId()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id)
    {
        this.id = id;
    }

    /**
     * @return the user
     */
    public User getUser()
    {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user)
    {
        this.user = user;
    }

    /**
     * @return the realname
     */
    public String getRealname()
    {
        return realname;
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
        return birthday;
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
        return age;
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
        return gender;
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
        return province;
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
        return city;
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
        return registrytype;
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
        return registryno;
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
        return email;
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
        return cellphone;
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
        return telephone;
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
        return faxno;
    }

    /**
     * @param faxno the faxno to set
     */
    public void setFaxno(String faxno)
    {
        this.faxno = faxno;
    }

}
