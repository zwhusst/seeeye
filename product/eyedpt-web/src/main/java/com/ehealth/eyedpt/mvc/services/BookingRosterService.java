/*
 * Created on 2011-9-18
 */

package com.ehealth.eyedpt.mvc.services;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.ehealth.eyedpt.dal.entities.BookingRoster;
import com.ehealth.eyedpt.dal.entities.Doctor;
import com.ehealth.eyedpt.dal.repositories.BookingRosterDao;
import com.ehealth.eyedpt.mvc.json.BookingRosterJSON;

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

    /**
     * @param doctor
     * @param rosters
     */
    public void replaceAll(Doctor doctor, BookingRosterJSON[] rosters)
    {
        Assert.notNull(doctor);
        Assert.notNull(rosters);

        // clean first
        deleteAll(doctor);

        // add new rosters
        HashSet<BookingRosterJSON> rosterSet = new HashSet<BookingRosterJSON>();
        rosterSet.addAll(Arrays.asList(rosters));
        
        for (BookingRosterJSON json : rosterSet)
        {
            BookingRoster roster = new BookingRoster();
            roster.setDoctor(doctor);
            roster.setDayofweek(json.getDayOfWeek());
            roster.setTimeslot(json.getTimeSlot());
            roster.setCapability(json.getCapability());
            this.bookingRosterDao.create(roster);
        }
    }

}
