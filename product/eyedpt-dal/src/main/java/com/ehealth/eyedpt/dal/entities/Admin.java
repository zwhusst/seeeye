/*
 * Created on 2011-8-7
 */

package com.ehealth.eyedpt.dal.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author emac
 */
@Entity(name = "admin")
@Table(name = "admin")
public class Admin
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long            id;

    @OneToOne(optional = false)
    @Column(name = "userid", nullable = false)
    @NotNull
    private User            user;

    @ManyToOne(optional = false)
    @Column(name = "hospitalid", nullable = false)
    @NotNull
    private Hospital        hospital;

    @ManyToMany
    @JoinTable(name = "admdep", joinColumns = @JoinColumn(name = "departmentid", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "adminid", referencedColumnName = "id"))
    private Set<Department> departments;

    @Column
    private boolean         root;

    @Column(nullable = false, length = 64)
    @NotNull
    @Size(max = 64)
    private String          email;

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
     * @return the departments
     */
    public Set<Department> getDepartments()
    {
        return departments;
    }

    /**
     * @param departments the departments to set
     */
    public void setDepartments(Set<Department> departments)
    {
        this.departments = departments;
    }

    /**
     * @return the root
     */
    public boolean isRoot()
    {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void setRoot(boolean root)
    {
        this.root = root;
    }

}
