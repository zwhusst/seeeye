/*
 * Created on 2011-8-21
 */

package com.ehealth.eyedpt.mvc.form.models;

import java.util.Date;

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

import com.ehealth.eyedpt.dal.entities.Doctor;
import com.ehealth.eyedpt.dal.entities.DoctorBlob;
import com.ehealth.eyedpt.dal.entities.enums.DoctorAdminTitle;
import com.ehealth.eyedpt.dal.entities.enums.DoctorTitle;
import com.ehealth.eyedpt.dal.entities.enums.ExpertRank;
import com.ehealth.eyedpt.dal.entities.enums.Gender;
import com.ehealth.eyedpt.dal.entities.enums.SupervisorType;

/**
 * @author emac
 */
public class DoctorBean extends UserBean
{

    @Size(min = 2, max = 32)
    private String           realname;

    @NotNull
    private Gender           gender         = Gender.M;

    @DateTimeFormat(iso = ISO.DATE)
    @Past
    private Date             birthday;

    @Min(1)
    @Max(99)
    private int              age;

    @NotEmpty
    @Email
    @Size(max = 64)
    private String           email;

    @Pattern(regexp = "\\d{11}")
    private String           cellphone;

    @Size(max = 32)
    private String           telephone;

    @NotEmpty
    @Size(max = 256)
    private String           address;

    @NotEmpty
    @Size(max = 32)
    private String           employeeid;

    @NotNull
    private DoctorTitle      title;

    @NotNull
    private DoctorAdminTitle admintitle;

    @NotNull
    private ExpertRank       expertrank     = ExpertRank.VIP;

    @DateTimeFormat(iso = ISO.DATE)
    @Past
    private Date             firstrecruit;

    @DateTimeFormat(iso = ISO.DATE)
    @Past
    private Date             lastpromote;

    @NotEmpty
    @Size(max = 128)
    private String           specialities;

    @Size(max = 128)
    private String           colleage;

    @Size(max = 32)
    private String           major;

    @Size(max = 32)
    private String           secondmajor;

    @Size(max = 16)
    private String           degree;

    @Size(max = 16)
    private String           education;

    @NotNull
    private SupervisorType   supervisortype = SupervisorType.DOCTOR;

    private String           supervisiorcolleges;

    // @Size(max = 1024 * 1024 * 2)
    // 2M
    private byte[]           photo;

    @Size(max = 1024 * 2)
    // 2K
    private String           description;

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
     * @return the address
     */
    public String getAddress()
    {
        return this.address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address)
    {
        this.address = address;
    }

    /**
     * @return the employeeid
     */
    public String getEmployeeid()
    {
        return this.employeeid;
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
        return this.title;
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
        return this.admintitle;
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
        return this.lastpromote;
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
        return this.specialities;
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
        return this.colleage;
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
        return this.major;
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
        return this.secondmajor;
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
        return this.degree;
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
        return this.education;
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
     * @return the supervisortype
     */
    public SupervisorType getSupervisortype()
    {
        return this.supervisortype;
    }

    /**
     * @param supervisortype the supervisortype to set
     */
    public void setSupervisortype(SupervisorType supervisortype)
    {
        this.supervisortype = supervisortype;
    }

    /**
     * @return the supervisiorcolleges
     */
    public String getSupervisiorcolleges()
    {
        return this.supervisiorcolleges;
    }

    /**
     * @param supervisiorcolleges the supervisiorcolleges to set
     */
    public void setSupervisiorcolleges(String supervisiorcolleges)
    {
        this.supervisiorcolleges = supervisiorcolleges;
    }

    /**
     * @return the photo
     */
    public byte[] getPhoto()
    {
        return this.photo;
    }

    /**
     * @param photo the photo to set
     */
    public void setPhoto(byte[] photo)
    {
        this.photo = photo;
    }

    /**
     * @return the description
     */
    public String getDescription()
    {
        return this.description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * @param doctor
     * @return
     */
    public static DoctorBean fromEntity(Doctor doctor)
    {
        DoctorBean bean = new DoctorBean();
        bean.setName(doctor.getUser().getName());
        bean.setPassword(doctor.getUser().getPassword());
        bean.setRealname(doctor.getRealname());
        bean.setGender(doctor.getGender());
        bean.setBirthday(doctor.getBirthday());
        bean.setAge(doctor.getAge());
        bean.setEmail(doctor.getEmail());
        bean.setCellphone(doctor.getCellphone());
        bean.setTelephone(doctor.getTelephone());
        bean.setAddress(doctor.getAddress());
        bean.setEmployeeid(doctor.getEmployeeid());
        bean.setTitle(doctor.getTitle());
        bean.setAdmintitle(doctor.getAdmintitle());
        bean.setExpertrank(doctor.getExpertrank());
        bean.setFirstrecruit(doctor.getFirstrecruit());
        bean.setLastpromote(doctor.getLastpromote());
        bean.setSpecialities(doctor.getSpecialities());
        bean.setColleage(doctor.getColleage());
        bean.setMajor(doctor.getMajor());
        bean.setSecondmajor(doctor.getSecondmajor());
        bean.setDegree(doctor.getDegree());
        bean.setEducation(doctor.getEducation());
        bean.setSupervisortype(doctor.getSupervisortype());
        bean.setSupervisiorcolleges(doctor.getSupervisiorcolleges());

        return bean;
    }

    /**
     * @param doctorBlob
     */
    public void mergeBlob(DoctorBlob doctorBlob)
    {
        if ( doctorBlob == null )
        {
            return;
        }

        setPhoto(doctorBlob.getPhoto());
        setDescription(doctorBlob.getDescription());
    }

}
