/*
 * Created on 2011-9-18
 */

package com.ehealth.eyedpt.mvc.controllers;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ehealth.eyedpt.dal.entities.BookingEx;
import com.ehealth.eyedpt.dal.entities.Doctor;
import com.ehealth.eyedpt.dal.entities.DoctorCap;
import com.ehealth.eyedpt.mvc.json.BookingExJSON;
import com.ehealth.eyedpt.mvc.json.BookingRosterJSON;
import com.ehealth.eyedpt.mvc.services.BookingExService;
import com.ehealth.eyedpt.mvc.services.BookingFacade;
import com.ehealth.eyedpt.mvc.services.BookingRosterService;
import com.ehealth.eyedpt.mvc.services.DoctorCapService;
import com.ehealth.eyedpt.mvc.services.DoctorService;
import com.ehealth.eyedpt.mvc.utils.CharsetUtils;

/**
 * @author emac
 */
@Controller
public class BookingController
{

    private static Logger        logger                      = Logger.getLogger(BookingController.class);

    public static final String   MAPPING_SETTING             = "/booking/setting";
    public static final String   MAPPING_SETTING_ACTIVATE    = "/booking/setting/activate";
    public static final String   MAPPING_SETTING_DEACTIVATE  = "/booking/setting/deactivate";
    public static final String   MAPPING_SETTING_SETCAP      = "/booking/setting/setcap";
    public static final String   MAPPING_SETTING_SAVEROSTERS = "/booking/setting/saverosters";
    public static final String   MAPPING_MGMT                = "/booking/mgmt";

    @Autowired
    private DoctorCapService     doctorCapService;

    @Autowired
    private BookingExService     bookingExService;

    @Autowired
    private BookingFacade        bookingFacade;

    @Autowired
    private BookingRosterService bookingRosterService;

    @Autowired
    private DoctorService        doctorService;

    @RequestMapping(value = MAPPING_SETTING, method = RequestMethod.GET)
    @PreAuthorize("hasRole('BOOKING_ADMIN')")
    public void doSetting()
    {
        // NTD
    }

    @RequestMapping(value = MAPPING_SETTING_ACTIVATE, method = RequestMethod.POST)
    @PreAuthorize("hasRole('BOOKING_ADMIN')")
    public @ResponseBody
    void doSettingActivate(@RequestParam String employeeId, @RequestParam float price)
    {
        if ( StringUtils.isEmpty(employeeId) )
        {
            logger.error("The employee ID of doctor cannot be empty!");

            return;
        }

        if ( price <= 0 )
        {
            logger.error("The booking price must be greater than 0!");

            return;
        }

        employeeId = CharsetUtils.translate(employeeId);
        DoctorCap cap = this.doctorCapService.findByEmployeeId(employeeId);
        Assert.notNull(cap);

        cap.setAcceptbookings(true);
        cap.setBookingprice(price);
        this.doctorCapService.update(cap);

        logger.info("Booking service activated: " + employeeId + "," + price);
    }

    @RequestMapping(value = MAPPING_SETTING_DEACTIVATE, method = RequestMethod.GET)
    @PreAuthorize("hasRole('BOOKING_ADMIN')")
    public @ResponseBody
    BookingExJSON doSettingDeactivate(@RequestParam String employeeId)
    {
        if ( StringUtils.isEmpty(employeeId) )
        {
            logger.error("The employee ID of doctor cannot be empty!");

            return null;
        }

        employeeId = CharsetUtils.translate(employeeId);
        BookingEx ex = this.bookingExService.findByEmployeeId(employeeId);

        if ( ex == null )
        {
            return null;
        }

        BookingExJSON json = new BookingExJSON();
        json.setStartDate(ex.getStartdate());
        json.setEndDate(ex.getEnddate());

        return json;
    }

    @RequestMapping(value = MAPPING_SETTING_DEACTIVATE, method = RequestMethod.POST)
    @PreAuthorize("hasRole('BOOKING_ADMIN')")
    public @ResponseBody
    void doSettingDeactivate(@RequestParam String employeeId, @RequestParam boolean permanent,
            @RequestParam(required = false) @DateTimeFormat(iso = ISO.DATE) Date startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = ISO.DATE) Date endDate)
    {
        if ( StringUtils.isEmpty(employeeId) )
        {
            logger.error("The employee ID of doctor cannot be empty!");

            return;
        }

        if ( permanent )
        {
            this.bookingFacade.declineBookings(employeeId);
        }
        else
        {
            if ( endDate.compareTo(startDate) < 0 )
            {
                logger.error("The end date must not be earlier than the start date!");

                return;
            }

            this.bookingExService.upsert(employeeId, startDate, endDate);
        }
    }

    @RequestMapping(value = MAPPING_SETTING_SETCAP, method = RequestMethod.GET)
    @PreAuthorize("hasRole('BOOKING_ADMIN')")
    public @ResponseBody
    Float doSettingSetcap(@RequestParam String employeeId)
    {
        if ( StringUtils.isEmpty(employeeId) )
        {
            logger.error("The employee ID of doctor cannot be empty!");

            return null;
        }

        employeeId = CharsetUtils.translate(employeeId);
        DoctorCap cap = this.doctorCapService.findByEmployeeId(employeeId);
        Assert.notNull(cap);

        return cap.getBookingprice();
    }

    @RequestMapping(value = MAPPING_SETTING_SETCAP, method = RequestMethod.POST)
    @PreAuthorize("hasRole('BOOKING_ADMIN')")
    public @ResponseBody
    void doSettingSetcap(@RequestParam String employeeId, @RequestParam float price)
    {
        if ( StringUtils.isEmpty(employeeId) )
        {
            logger.error("The employee ID of doctor cannot be empty!");

            return;
        }

        if ( price <= 0 )
        {
            logger.error("The booking price must be greater than 0!");

            return;
        }

        employeeId = CharsetUtils.translate(employeeId);
        DoctorCap cap = this.doctorCapService.findByEmployeeId(employeeId);
        Assert.notNull(cap);

        cap.setBookingprice(price);
        this.doctorCapService.update(cap);

        logger.info("Booking price updated: " + employeeId + "," + price);
    }

    @RequestMapping(value = MAPPING_SETTING_SAVEROSTERS, method = RequestMethod.POST)
    @PreAuthorize("hasRole('BOOKING_ADMIN')")
    public @ResponseBody
    void doSettingSaverosters(@RequestParam String employeeId, @RequestBody BookingRosterJSON[] rosters)
    {
        if ( StringUtils.isEmpty(employeeId) )
        {
            logger.error("The employee ID of doctor cannot be empty!");

            return;
        }

        employeeId = CharsetUtils.translate(employeeId);
        Doctor doctor = this.doctorService.findByEmployeeId(employeeId);
        Assert.notNull(doctor);

        this.bookingRosterService.replaceAll(doctor, rosters);

        logger.info("Booking roster updated: " + employeeId);
    }

    @RequestMapping(value = MAPPING_MGMT, method = RequestMethod.GET)
    @PreAuthorize("hasRole('BOOKING_ADMIN')")
    public void doManagement()
    {
        // NTD
    }

}
