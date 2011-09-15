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

import com.ehealth.eyedpt.dal.entities.enums.DoctorAdminTitle;
import com.ehealth.eyedpt.dal.entities.enums.DoctorTitle;
import com.ehealth.eyedpt.dal.entities.enums.ExpertRank;
import com.ehealth.eyedpt.dal.entities.enums.Gender;
import com.ehealth.eyedpt.dal.entities.enums.SupervisorType;

/**
 * @author emac
 */
@Entity(name = "doctor")
@Table(name = "doctor")
@NamedQueries(
{
        @NamedQuery(name = Doctor.QUERY_FIND_ALL, query = "select d from doctor d"),
        @NamedQuery(name = Doctor.QUERY_FIND_BY_USER, query = "select d from doctor d where d.user=:user"),
        @NamedQuery(name = Doctor.QUERY_FIND_BY_EMPLOYEE_ID, query = "select d from doctor d where d.employeeid=:employeeid")})
public class Doctor
{

    public static final String QUERY_FIND_ALL            = "FindAllDoctors";
    public static final String QUERY_FIND_BY_USER        = "FindDoctorByUser";
    public static final String QUERY_FIND_BY_EMPLOYEE_ID = "FindDoctorByEmployeeId";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long               id;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @Column(name = "userid", nullable = false)
    private User               user;

    @Column(nullable = false, length = 32)
    private String             realname;

    @Column(nullable = false)
    private Gender             gender;

    @Column
    private Date               birthday;

    @Column(nullable = false, columnDefinition = "TINYINT")
    private int                age;

    @Column(nullable = false, length = 64)
    private String             email;

    @Column(nullable = false, length = 11)
    private String             cellphone;

    @Column(length = 32)
    private String             telephone;

    @Column(nullable = false, length = 256)
    private String             address;

    @ManyToOne(optional = false, cascade =
    { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @Column(name = "hospitalid", nullable = false)
    private Hospital           hospital;

    @ManyToOne(optional = false, cascade =
    { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @Column(name = "departmentid", nullable = false)
    private Department         department;

    @Column(nullable = false, unique = true, length = 32)
    private String             employeeid;

    @Column(nullable = false)
    private DoctorTitle        title;

    @Column(nullable = false)
    private DoctorAdminTitle   admintitle;

    @Column(nullable = false)
    private ExpertRank         expertrank;

    @Column
    private Date               firstrecruit;

    @Column
    private Date               lastpromote;

    @Column(nullable = false, length = 128)
    private String             specialities;

    @Column(length = 128)
    private String             colleage;

    @Column(length = 32)
    private String             major;

    @Column(length = 32)
    private String             secondmajor;

    @Column(length = 16)
    private String             degree;

    @Column(length = 16)
    private String             education;

    @Column(nullable = false)
    private SupervisorType     supervisortype1;

    @Column(length = 64)
    private String             supervisiorcollege1;
    
    @Column(nullable = false)
    private SupervisorType     supervisortype2;

    @Column(length = 64)
    private String             supervisiorcollege2;
    
    @Column(nullable = false)
    private SupervisorType     supervisortype3;

    @Column(length = 64)
    private String             supervisiorcollege3;

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
    public DoctorTitle getTitle()
    {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(DoctorTitle title)
    {
        this.title = title;
    }

    /**
     * @return the admintitle
     */
    public DoctorAdminTitle getAdmintitle()
    {
        return admintitle;
    }

    /**
     * @param admintitle the admintitle to set
     */
    public void setAdmintitle(DoctorAdminTitle admintitle)
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
     * @return the expertrank
     */
    public ExpertRank getExpertrank()
    {
        return this.expertrank;
    }

    /**
     * @param expertrank the expertrank to set
     */
    public void setExpertrank(ExpertRank expertrank)
    {
        this.expertrank = expertrank;
    }

    /**
     * @return the firstrecruit
     */
    public Date getFirstrecruit()
    {
        return this.firstrecruit;
    }

    /**
     * @param firstrecruit the firstrecruit to set
     */
    public void setFirstrecruit(Date firstrecruit)
    {
        this.firstrecruit = firstrecruit;
    }

    /**
     * @return the supervisortype1
     */
    public SupervisorType getSupervisortype1()
    {
        return this.supervisortype1;
    }

    /**
     * @param supervisortype1 the supervisortype1 to set
     */
    public void setSupervisortype1(SupervisorType supervisortype1)
    {
        this.supervisortype1 = supervisortype1;
    }

    /**
     * @return the supervisiorcollege1
     */
    public String getSupervisiorcollege1()
    {
        return this.supervisiorcollege1;
    }

    /**
     * @param supervisiorcollege1 the supervisiorcollege1 to set
     */
    public void setSupervisiorcollege1(String supervisiorcollege1)
    {
        this.supervisiorcollege1 = supervisiorcollege1;
    }

    /**
     * @return the supervisortype2
     */
    public SupervisorType getSupervisortype2()
    {
        return this.supervisortype2;
    }

    /**
     * @param supervisortype2 the supervisortype2 to set
     */
    public void setSupervisortype2(SupervisorType supervisortype2)
    {
        this.supervisortype2 = supervisortype2;
    }

    /**
     * @return the supervisiorcollege2
     */
    public String getSupervisiorcollege2()
    {
        return this.supervisiorcollege2;
    }

    /**
     * @param supervisiorcollege2 the supervisiorcollege2 to set
     */
    public void setSupervisiorcollege2(String supervisiorcollege2)
    {
        this.supervisiorcollege2 = supervisiorcollege2;
    }

    /**
     * @return the supervisortype3
     */
    public SupervisorType getSupervisortype3()
    {
        return this.supervisortype3;
    }

    /**
     * @param supervisortype3 the supervisortype3 to set
     */
    public void setSupervisortype3(SupervisorType supervisortype3)
    {
        this.supervisortype3 = supervisortype3;
    }

    /**
     * @return the supervisiorcollege3
     */
    public String getSupervisiorcollege3()
    {
        return this.supervisiorcollege3;
    }

    /**
     * @param supervisiorcollege3 the supervisiorcollege3 to set
     */
    public void setSupervisiorcollege3(String supervisiorcollege3)
    {
        this.supervisiorcollege3 = supervisiorcollege3;
    }

}
