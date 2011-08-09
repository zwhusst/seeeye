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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.ehealth.eyedpt.dal.entities.enums.Gender;

/**
 * @author emac
 */
@Entity(name = "doctor")
@Table(name = "doctor")
@NamedQueries(
{ @NamedQuery(name = Doctor.QUERY_FIND_ALL, query = "select d from doctor d")})
public class Doctor
{

    public static final String QUERY_FIND_ALL = "FindAllDoctors"; //$NON-NLS-1$

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

    @Column(length = 256)
    @Size(max = 256)
    private String             address;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @Column(name = "hospitalid", nullable = false)
    @NotNull
    private Hospital           hospital;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @Column(name = "departmentid", nullable = false)
    @NotNull
    private Department         department;

    @Column(nullable = false, length = 32)
    @NotNull
    @Size(max = 32)
    private String             employeeid;

    @Column(nullable = false, length = 128)
    @NotNull
    @Size(max = 128)
    private String             title;

    @Column(nullable = false, length = 128)
    @NotNull
    @Size(max = 128)
    private String             admintitle;

    @Column
    @Past
    private Date               lastpromote;

    @Column(nullable = false, length = 128)
    @NotNull
    @Size(max = 128)
    private String             specialities;

    @Column(length = 128)
    @Size(max = 128)
    private String             colleage;

    @Column(length = 32)
    @Size(max = 32)
    private String             major;

    @Column(length = 32)
    @Size(max = 32)
    private String             secondmajor;

    @Column(length = 16)
    @Size(max = 16)
    private String             degree;

    @Column(length = 16)
    @Size(max = 16)
    private String             education;

    @Column
    private boolean            supervisor;

    @Column
    private boolean            doctoralsupervisior;

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
     * @return the department
     */
    public Department getDepartment()
    {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(Department department)
    {
        this.department = department;
    }

    /**
     * @return the employeeid
     */
    public String getEmployeeid()
    {
        return employeeid;
    }

    /**
     * @param employeeid the employeeid to set
     */
    public void setEmployeeid(String employeeid)
    {
        this.employeeid = employeeid;
    }

    /**
     * @return the title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * @return the admintitle
     */
    public String getAdmintitle()
    {
        return admintitle;
    }

    /**
     * @param admintitle the admintitle to set
     */
    public void setAdmintitle(String admintitle)
    {
        this.admintitle = admintitle;
    }

    /**
     * @return the lastpromote
     */
    public Date getLastpromote()
    {
        return lastpromote;
    }

    /**
     * @param lastpromote the lastpromote to set
     */
    public void setLastpromote(Date lastpromote)
    {
        this.lastpromote = lastpromote;
    }

    /**
     * @return the specialities
     */
    public String getSpecialities()
    {
        return specialities;
    }

    /**
     * @param specialities the specialities to set
     */
    public void setSpecialities(String specialities)
    {
        this.specialities = specialities;
    }

    /**
     * @return the colleage
     */
    public String getColleage()
    {
        return colleage;
    }

    /**
     * @param colleage the colleage to set
     */
    public void setColleage(String colleage)
    {
        this.colleage = colleage;
    }

    /**
     * @return the major
     */
    public String getMajor()
    {
        return major;
    }

    /**
     * @param major the major to set
     */
    public void setMajor(String major)
    {
        this.major = major;
    }

    /**
     * @return the secondmajor
     */
    public String getSecondmajor()
    {
        return secondmajor;
    }

    /**
     * @param secondmajor the secondmajor to set
     */
    public void setSecondmajor(String secondmajor)
    {
        this.secondmajor = secondmajor;
    }

    /**
     * @return the degree
     */
    public String getDegree()
    {
        return degree;
    }

    /**
     * @param degree the degree to set
     */
    public void setDegree(String degree)
    {
        this.degree = degree;
    }

    /**
     * @return the education
     */
    public String getEducation()
    {
        return education;
    }

    /**
     * @param education the education to set
     */
    public void setEducation(String education)
    {
        this.education = education;
    }

    /**
     * @return the supervisor
     */
    public boolean isSupervisor()
    {
        return supervisor;
    }

    /**
     * @param supervisor the supervisor to set
     */
    public void setSupervisor(boolean supervisor)
    {
        this.supervisor = supervisor;
    }

    /**
     * @return the doctoralsupervisior
     */
    public boolean isDoctoralsupervisior()
    {
        return doctoralsupervisior;
    }

    /**
     * @param doctoralsupervisior the doctoralsupervisior to set
     */
    public void setDoctoralsupervisior(boolean doctoralsupervisior)
    {
        this.doctoralsupervisior = doctoralsupervisior;
    }

}
