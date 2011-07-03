/*
 * Created on 2011-6-27
 */

package org.seeeye.dal.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author emac
 */
@Entity
@Table(name = "employee")
@NamedQueries(
{ @NamedQuery(name = Employee.QUERY_FIND_ALL, query = "select e from Employee e"),
        @NamedQuery(name = Employee.QUERY_FIND_BY_NAME, query = "select e from Employee e where e.name=?1")})
public class Employee
{

    public static final String QUERY_FIND_ALL     = "FindAllEmployees";
    public static final String QUERY_FIND_BY_NAME = "FindEmployeeByName";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int                id;

    @Basic
    private String             name;

    @Basic
    private Gender             gender;

    @Basic
    private int                age;

    @Basic
    private Title              title;

    @ManyToOne
    private Employee           manager;

    public static enum Gender
    {
        M, F
    }

    public static enum Title
    {
        CEO, MANAGER, EMPLOYEE
    }

    /**
     * @return the id
     */
    public int getId()
    {
        return id;
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
     * @return the manager
     */
    public Employee getManager()
    {
        return manager;
    }

    /**
     * @param manager the manager to set
     */
    public void setManager(Employee manager)
    {
        this.manager = manager;
    }

    /**
     * @return the title
     */
    public Title getTitle()
    {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(Title title)
    {
        this.title = title;
    }

}
