/*
 * Created on 2011-9-25
 */

package com.ehealth.eyedpt.mvc.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.ehealth.eyedpt.dal.entities.BookingEx;
import com.ehealth.eyedpt.dal.entities.Doctor;
import com.ehealth.eyedpt.dal.repositories.BookingExDao;
import com.ehealth.eyedpt.dal.repositories.DoctorDao;

/**
 * @author emac
 */
@Service
public class BookingExService
{

    @Autowired
    private BookingExDao bookingExDao;

    @Autowired
    private DoctorDao    doctorDao;

    /**
     * @param doctor
     * @return
     */
    public BookingEx findByDoctor(Doctor doctor)
    {
        return this.bookingExDao.findByDoctor(doctor);
    }

    /**
     * @param employeeId
     * @return
     */
    public BookingEx findByEmployeeId(String employeeId)
    {
        Doctor doctor = this.doctorDao.findByEmployeeId(employeeId);

        return findByDoctor(doctor);
    }

    /**
     * @param doctor
     * @param startDate
     * @param endDate
     */
    public void create(Doctor doctor, Date startDate, Date endDate)
    {
        Assert.notNull(doctor);
        Assert.notNull(startDate);
        Assert.notNull(endDate);

        BookingEx ex = new BookingEx();
        ex.setDoctor(doctor);
        ex.setStartdate(new java.sql.Date(startDate.getTime()));
        ex.setEnddate(new java.sql.Date(endDate.getTime()));

        this.bookingExDao.create(ex);
    }

    /**
     * @param ex
     * @param startDate
     * @param endDate
     * @return
     */
    public BookingEx update(BookingEx ex, Date startDate, Date endDate)
    {
        Assert.notNull(ex);
        Assert.notNull(startDate);
        Assert.notNull(endDate);

        ex.setStartdate(new java.sql.Date(startDate.getTime()));
        ex.setEnddate(new java.sql.Date(endDate.getTime()));

        return this.bookingExDao.update(ex);
    }

    /**
     * @param employeeId
     * @param startDate
     * @param endDate
     */
    public void upsert(String employeeId, Date startDate, Date endDate)
    {
        BookingEx ex = findByEmployeeId(employeeId);

        if ( ex == null )
        {
            // insert
            Doctor doctor = this.doctorDao.findByEmployeeId(employeeId);
            create(doctor, startDate, endDate);
        }
        else
        {
            // update
            update(ex, startDate, endDate);
        }
    }

    /**
     * @param ex
     */
    public void delete(BookingEx ex)
    {
        Assert.notNull(ex);

        this.bookingExDao.delete(ex);
    }

}
