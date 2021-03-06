/*
 * Created on 2011-7-30
 */

package com.ehealth.eyedpt.dal.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.ehealth.eyedpt.dal.entities.enums.UserGroup;

/**
 * @author emac
 */
@Entity(name = "user")
@Table(name = "user")
@NamedQueries(
{ @NamedQuery(name = User.QUERY_FIND_ALL, query = "select u from user u"),
        @NamedQuery(name = User.QUERY_FIND_BY_NAME, query = "select u from user u where u.name=:name")})
public class User
{

    public static final String QUERY_FIND_ALL     = "FindAllUsers";
    public static final String QUERY_FIND_BY_NAME = "FindUserByName";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long               id;

    @Column(nullable = false, length = 16)
    private String             name;

    @Column(nullable = false, length = 16)
    private String             password;

    @Column(nullable = false)
    private UserGroup          usergroup;

    @Column(nullable = false, columnDefinition = "BIT(32)")
    private byte[]             roleset            = new byte[32];

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
     * @return the password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * @return the usergroup
     */
    public UserGroup getUsergroup()
    {
        return usergroup;
    }

    /**
     * @param usergroup the usergroup to set
     */
    public void setUsergroup(UserGroup usergroup)
    {
        this.usergroup = usergroup;
    }

    /**
     * @return the roleset
     */
    public byte[] getRoleset()
    {
        return roleset;
    }

    /**
     * @param roleset the roleset to set
     */
    public void setRoleset(byte[] roleset)
    {
        this.roleset = roleset;
    }

}
