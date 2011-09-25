/*
 * Created on 2011-9-18
 */

package com.ehealth.eyedpt.mvc.services;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehealth.eyedpt.dal.entities.BookingRoster;
import com.ehealth.eyedpt.dal.entities.Doctor;
import com.ehealth.eyedpt.dal.repositories.BookingRosterDao;

/**
 * @author emac
 */
@Service
public class BookingRosterService
{

    @Autowired
    private BookingRosterDao bookingRosterDao;

    /**
     * @param doctor
     * @return
     */
    public List<BookingRoster> findByDoctor(Doctor doctor)
    {
        return this.bookingRosterDao.findByDoctor(doctor);
    }

    /**
     * Composes a short message from all registered service time of the given doctor.
     * 
     * @param doctor
     * @return
     */
    public String getServiceTime(Doctor doctor)
    {
        StringBuilder sbuilder = new StringBuilder();
        for (BookingRoster br : findByDoctor(doctor))
        {
            sbuilder.append(br.getDayofweek().getLabel());
            sbuilder.append(br.getTimeslot().getLabel());
            sbuilder.append(",");
        }

        String serviceTime = sbuilder.toString();
        if ( StringUtils.isEmpty(serviceTime) )
        {
            return serviceTime;
        }

        return serviceTime.substring(0, serviceTime.length() - 1);
    }

    /**
     * @param doctor
     */
    public void deleteAll(Doctor doctor)
    {
        for (BookingRoster r : findByDoctor(doctor))
        {
            this.bookingRosterDao.delete(r);
        }
    }

}
