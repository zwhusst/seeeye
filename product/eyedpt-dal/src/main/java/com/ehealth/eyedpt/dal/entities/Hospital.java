/*
 * Created on 2011-8-7
 */

package com.ehealth.eyedpt.dal.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author emac
 */
@Entity(name = "hospital")
@Table(name = "hospital")
@NamedQueries(
{ @NamedQuery(name = Hospital.QUERY_FIND_ALL, query = "select h from hospital h")})
public class Hospital
{

    public static final String QUERY_FIND_ALL = "FindAllHospitals"; //$NON-NLS-1$

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long               id;

    @Column(nullable = false, length = 128)
    @NotNull
    @Size(max = 128)
    private String             name;

    @Column(nullable = false, length = 32)
    @NotNull
    @Size(max = 32)
    private String             province;

    @Column(nullable = false, length = 32)
    @NotNull
    @Size(max = 32)
    private String             city;

    @Column(nullable = false, length = 256)
    @NotNull
    @Size(max = 256)
    private String             address;

    @Column(nullable = false, length = 6)
    @NotNull
    @Size(min = 6, max = 6)
    private String             postcode;

    @Column(nullable = false, length = 32)
    @NotNull
    @Size(max = 32)
    private String             telephone;

    @Column(length = 32)
    @Size(max = 32)
    private String             faxno;

    @Column(length = 64)
    @Size(max = 64)
    private String             email;

    @Lob
//    @Column(columnDefinition = "TEXT")
    @Column(columnDefinition = "CLOB")
    private String             description;

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
     * @return the address
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address)
    {
        this.address = address;
    }

    /**
     * @return the postcode
     */
    public String getPostcode()
    {
        return postcode;
    }

    /**
     * @param postcode the postcode to set
     */
    public void setPostcode(String postcode)
    {
        this.postcode = postcode;
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
     * @return the description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

}
