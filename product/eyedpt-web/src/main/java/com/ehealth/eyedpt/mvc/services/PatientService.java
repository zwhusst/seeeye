/*
 * Created on 2011-8-10
 */

package com.ehealth.eyedpt.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.ehealth.eyedpt.dal.entities.Patient;
import com.ehealth.eyedpt.dal.entities.User;
import com.ehealth.eyedpt.dal.entities.enums.UserGroup;
import com.ehealth.eyedpt.dal.repositories.PatientDao;
import com.ehealth.eyedpt.dal.repositories.UserDao;
import com.ehealth.eyedpt.mvc.form.models.PatientBean;

/**
 * @author emac
 */
@Service
public class PatientService
{

    @Autowired
    private UserDao     userDao;

    @Autowired
    private PatientDao  patientDao;

    /**
     * @param user
     * @return
     */
    public Patient findByUser(User user)
    {
        return this.patientDao.findByUser(user);
    }

    /**
     * @param bean
     * @return
     */
    public Patient createPatient(PatientBean bean)
    {
        User user = new User();
        user.setName(bean.getName());
        user.setPassword(bean.getPassword());
        user.setUsergroup(UserGroup.PATIENT);

        Patient patient = new Patient();
        patient.setUser(user);
        patient.setRealname(bean.getRealname());
        patient.setGender(bean.getGender());
        patient.setBirthday(bean.getBirthday());
        patient.setAge(bean.getAge());
        patient.setProvince(bean.getProvince());
        patient.setCity(bean.getCity());
        patient.setRegistrytype(bean.getRegistrytype());
        patient.setRegistryno(bean.getRegistryno());
        patient.setEmail(bean.getEmail());
        patient.setCellphone(bean.getCellphone());
        patient.setTelephone(bean.getTelephone());
        patient.setFaxno(bean.getFaxno());

        this.patientDao.create(patient);

        return patient;
    }

    /**
     * @param patientBean
     */
    public Patient updatePatient(PatientBean bean)
    {
        User user = this.userDao.findByName(bean.getName());
        Assert.notNull(user);

        Patient patient = findByUser(user);
        patient.setRealname(bean.getRealname());
        patient.setGender(bean.getGender());
        patient.setBirthday(bean.getBirthday());
        patient.setAge(bean.getAge());
        patient.setProvince(bean.getProvince());
        patient.setCity(bean.getCity());
        patient.setRegistrytype(bean.getRegistrytype());
        patient.setRegistryno(bean.getRegistryno());
        patient.setEmail(bean.getEmail());
        patient.setCellphone(bean.getCellphone());
        patient.setTelephone(bean.getTelephone());
        patient.setFaxno(bean.getFaxno());

        this.patientDao.update(patient);

        return patient;
    }

}
