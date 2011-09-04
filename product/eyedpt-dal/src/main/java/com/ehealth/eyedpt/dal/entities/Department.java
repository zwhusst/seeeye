/*
 * Created on 2011-8-7
 */

package com.ehealth.eyedpt.dal.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author emac
 */
@Entity(name = "department")
@Table(name = "department")
@NamedQueries(
{
        @NamedQuery(name = Department.QUERY_FIND_ALL, query = "select d from department d"),
        @NamedQuery(name = Department.QUERY_FIND_BY_HOSPTIAL_AND_NAME, query = "select d from department d where d.hospital=:hospital and d.name=:name")})
public class Department
{

    public static final String QUERY_FIND_ALL                  = "FindAllDepartments";
    public static final String QUERY_FIND_BY_HOSPTIAL_AND_NAME = "FindDepartmentByHospitalAndName";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long               id;

    @ManyToOne(optional = false, cascade =
    { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @Column(name = "hospitalid", nullable = false)
    @NotNull
    private Hospital           hospital;

    @ManyToMany(mappedBy = "departments")
    private Set<Admin>         admins;

    @Column(nullable = false, length = 128)
    @NotNull
    @Size(max = 128)
    private String             name;

    @Column
    private boolean            famous;

    @Column(length = 32)
    @Size(max = 32)
    private String             telephone;

    @Column(length = 32)
    @Size(max = 32)
    private String             faxno;

    @Column(length = 256)
    @Size(max = 256)
    private String             address;

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
     * @return the hospital
     */
    public Hospital getHospital()
    {
        return hospital;
    }

    /**
     * @param hospital the hospital to set
     */
    public void setHospital(Hospital hospital)
    {
        this.hospital = hospital;
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
     * @return the famous
     */
    public boolean isFamous()
    {
        return famous;
    }

    /**
     * @param famous the famous to set
     */
    public void setFamous(boolean famous)
    {
        this.famous = famous;
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

    /**
     * @return the admins
     */
    public Set<Admin> getAdmins()
    {
        return admins;
    }

    /**
     * @param admins the admins to set
     */
    public void setAdmins(Set<Admin> admins)
    {
        this.admins = admins;
    }

}
