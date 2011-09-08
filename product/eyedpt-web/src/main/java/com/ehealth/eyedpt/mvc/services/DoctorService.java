/*
 * Created on 2011-8-20
 */

package com.ehealth.eyedpt.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.ehealth.eyedpt.dal.components.DatabaseInitializer;
import com.ehealth.eyedpt.dal.entities.Department;
import com.ehealth.eyedpt.dal.entities.Doctor;
import com.ehealth.eyedpt.dal.entities.Hospital;
import com.ehealth.eyedpt.dal.entities.User;
import com.ehealth.eyedpt.dal.entities.enums.UserGroup;
import com.ehealth.eyedpt.dal.repositories.DepartmentDao;
import com.ehealth.eyedpt.dal.repositories.DoctorDao;
import com.ehealth.eyedpt.dal.repositories.HospitalDao;
import com.ehealth.eyedpt.dal.repositories.UserDao;
import com.ehealth.eyedpt.mvc.form.models.DoctorBean;

/**
 * @author emac
 */
@Service
public class DoctorService
{

    @Autowired
    private UserDao       userDao;

    @Autowired
    private DoctorDao     doctorDao;

    @Autowired
    private HospitalDao   hospitalDao;

    @Autowired
    private DepartmentDao departmentDao;

    /**
     * @return
     */
    public List<Doctor> findAll()
    {
        return this.doctorDao.findAll();
    }

    /**
     * @param user
     * @return
     */
    public Doctor findByUser(User user)
    {
        return this.doctorDao.findByUser(user);
    }

    /**
     * @param employeeId
     * @return
     */
    public Doctor findByEmployeeId(String employeeId)
    {
        return this.doctorDao.findByEmployeeId(employeeId);
    }

    /**
     * @param doctor
     */
    public void delete(Doctor doctor)
    {
        this.doctorDao.delete(doctor);
    }

    /**
     * @param bean
     * @return
     */
    public Doctor createDoctor(DoctorBean bean)
    {
        User user = new User();
        user.setName(bean.getName());
        user.setPassword(bean.getPassword());
        user.setUsergroup(UserGroup.DOCTOR);

        Doctor doctor = new Doctor();
        doctor.setUser(user);
        doctor.setRealname(bean.getRealname());
        doctor.setGender(bean.getGender());
        if ( bean.getBirthday() != null )
        {
            doctor.setBirthday(new java.sql.Date(bean.getBirthday().getTime()));
        }
        doctor.setAge(bean.getAge());
        doctor.setEmail(bean.getEmail());
        doctor.setCellphone(bean.getCellphone());
        doctor.setTelephone(bean.getTelephone());
        doctor.setAddress(bean.getAddress());
        doctor.setEmployeeid(bean.getEmployeeid());
        doctor.setTitle(bean.getTitle());
        doctor.setAdmintitle(bean.getAdmintitle());
        doctor.setExpertrank(bean.getExpertrank());
        if ( bean.getFirstrecruit() != null )
        {
            doctor.setFirstrecruit(new java.sql.Date(bean.getFirstrecruit().getTime()));
        }
        if ( bean.getLastpromote() != null )
        {
            doctor.setLastpromote(new java.sql.Date(bean.getLastpromote().getTime()));
        }
        doctor.setSpecialities(bean.getSpecialities());
        doctor.setColleage(bean.getColleage());
        doctor.setMajor(bean.getMajor());
        doctor.setSecondmajor(bean.getSecondmajor());
        doctor.setDegree(bean.getDegree());
        doctor.setEducation(bean.getEducation());
        doctor.setSupervisortype(bean.getSupervisortype());
        doctor.setSupervisiorcolleges(bean.getSupervisiorcolleges());

        Hospital hospital = this.hospitalDao.findByName(DatabaseInitializer.HOSTPITAL_NO1);
        doctor.setHospital(hospital);
        Department department = this.departmentDao.findByHospitalAndName(hospital, DatabaseInitializer.DEPARTMENT_EYE);
        doctor.setDepartment(department);
        this.doctorDao.create(doctor);

        return doctor;
    }

    /**
     * @param bean
     */
    public Doctor updateDoctor(DoctorBean bean)
    {
        User user = this.userDao.findByName(bean.getName());
        Assert.notNull(user);

        Doctor doctor = findByUser(user);
        Assert.notNull(doctor);

        doctor.setRealname(bean.getRealname());
        doctor.setGender(bean.getGender());
        if ( bean.getBirthday() != null )
        {
            doctor.setBirthday(new java.sql.Date(bean.getBirthday().getTime()));
        }
        doctor.setAge(bean.getAge());
        doctor.setEmail(bean.getEmail());
        doctor.setCellphone(bean.getCellphone());
        doctor.setTelephone(bean.getTelephone());
        doctor.setAddress(bean.getAddress());
        doctor.setEmployeeid(bean.getEmployeeid());
        doctor.setTitle(bean.getTitle());
        doctor.setAdmintitle(bean.getAdmintitle());
        doctor.setExpertrank(bean.getExpertrank());
        if ( bean.getFirstrecruit() != null )
        {
            doctor.setFirstrecruit(new java.sql.Date(bean.getFirstrecruit().getTime()));
        }
        if ( bean.getLastpromote() != null )
        {
            doctor.setLastpromote(new java.sql.Date(bean.getLastpromote().getTime()));
        }
        doctor.setSpecialities(bean.getSpecialities());
        doctor.setColleage(bean.getColleage());
        doctor.setMajor(bean.getMajor());
        doctor.setSecondmajor(bean.getSecondmajor());
        doctor.setDegree(bean.getDegree());
        doctor.setEducation(bean.getEducation());
        doctor.setSupervisortype(bean.getSupervisortype());
        doctor.setSupervisiorcolleges(bean.getSupervisiorcolleges());
        doctor = this.doctorDao.update(doctor);

        return doctor;
    }

}
