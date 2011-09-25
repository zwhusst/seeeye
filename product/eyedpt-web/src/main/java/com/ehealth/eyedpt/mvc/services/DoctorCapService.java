/*
 * Created on 2011-9-18
 */

package com.ehealth.eyedpt.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.ehealth.eyedpt.dal.entities.Doctor;
import com.ehealth.eyedpt.dal.entities.DoctorCap;
import com.ehealth.eyedpt.dal.repositories.DoctorCapDao;
import com.ehealth.eyedpt.dal.repositories.DoctorDao;

/**
 * @author emac
 */
@Service
public class DoctorCapService
{

    @Autowired
    private DoctorCapDao doctorCapDao;

    @Autowired
    private DoctorDao    doctorDao;

    /**
     * @param doctor
     * @return
     */
    public DoctorCap findByDoctor(Doctor doctor)
    {
        return this.doctorCapDao.findByDoctor(doctor);
    }

    /**
     * @param employeeId
     * @return
     */
    public DoctorCap findByEmployeeId(String employeeId)
    {
        Doctor doctor = this.doctorDao.findByEmployeeId(employeeId);

        return findByDoctor(doctor);
    }

    /**
     * @param doctor
     */
    public void create(Doctor doctor)
    {
        Assert.notNull(doctor);

        DoctorCap cap = new DoctorCap();
        cap.setDoctor(doctor);

        this.doctorCapDao.create(cap);
    }

    /**
     * @param cap
     * @return
     */
    public DoctorCap update(DoctorCap cap)
    {
        Assert.notNull(cap);

        return this.doctorCapDao.update(cap);
    }

    /**
     * Returns whether the given doctor accpets bookings.
     * 
     * @param doctor
     * @return
     */
    public boolean acceptBookings(Doctor doctor)
    {
        DoctorCap cap = findByDoctor(doctor);

        return cap == null ? false : cap.isAcceptbookings();
    }

}
