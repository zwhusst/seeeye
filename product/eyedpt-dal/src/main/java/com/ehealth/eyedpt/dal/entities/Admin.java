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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author emac
 */
@Entity(name = "admin")
@Table(name = "admin")
@NamedQueries(
{ @NamedQuery(name = Admin.QUERY_FIND_ALL, query = "select a from admin a"),
        @NamedQuery(name = Admin.QUERY_FIND_BY_USER, query = "select a from admin a where a.user=:user")})
public class Admin
{

    public static final String QUERY_FIND_ALL     = "FindAllAdmins";
    public static final String QUERY_FIND_BY_USER = "FindAdminByUser";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long               id;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @Column(name = "userid", nullable = false)
    private User               user;

    @ManyToOne(optional = false, cascade =
    { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @Column(name = "hospitalid", nullable = false)
    private Hospital           hospital;

    @ManyToMany(cascade =
    { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "admdep", joinColumns = @JoinColumn(name = "departmentid", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "adminid", referencedColumnName = "id"))
    private Set<Department>    departments;

    @Column
    private boolean            root;

    @Column(nullable = false, length = 64)
    private String             email;

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
