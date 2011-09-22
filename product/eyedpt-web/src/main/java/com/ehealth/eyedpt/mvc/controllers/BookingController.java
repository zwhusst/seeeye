/*
 * Created on 2011-9-18
 */

package com.ehealth.eyedpt.mvc.controllers;

import org.apache.log4j.Logger;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author emac
 */
@Controller
public class BookingController
{

    private static Logger      logger          = Logger.getLogger(BookingController.class);

    public static final String MAPPING_SETTING = "/booking/setting";
    public static final String MAPPING_MGMT    = "/booking/mgmt";

    @RequestMapping(value = MAPPING_SETTING, method = RequestMethod.GET)
    @PreAuthorize("hasRole('BOOKING_ADMIN')")
    public void doSetting()
    {
        // NTD
    }

    @RequestMapping(value = MAPPING_MGMT, method = RequestMethod.GET)
    @PreAuthorize("hasRole('BOOKING_ADMIN')")
    public void doManagement()
    {
        // NTD
    }

}
