/*
 * Created on 2011-9-18
 */

package com.ehealth.eyedpt.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehealth.eyedpt.dal.entities.Doctor;
import com.ehealth.eyedpt.dal.entities.DoctorCap;
import com.ehealth.eyedpt.dal.repositories.DoctorCapDao;

/**
 * @author emac
 */
@Service
public class DoctorCapService
{

    @Autowired
    private DoctorCapDao doctorCapDao;

    /**
     * @param doctor
     * @return
     */
    public DoctorCap findByDoctor(Doctor doctor)
    {
        return this.doctorCapDao.findByDoctor(doctor);
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
