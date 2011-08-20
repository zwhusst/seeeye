/*
 * Created on 2011-8-20
 */

package com.ehealth.eyedpt.mvc.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ehealth.eyedpt.mvc.components.MessageSourceProvider;
import com.ehealth.eyedpt.mvc.services.DoctorService;

/**
 * @author emac
 */
@Controller
public class DoctorController
{

    private static Logger         logger       = Logger.getLogger(DoctorController.class);

    public static final String    MAPPING_MGMT = "/doctor/mgmt";

    @Autowired
    private DoctorService         doctorService;

    @Autowired
    private MessageSourceProvider msp;

    @RequestMapping(value = MAPPING_MGMT, method = RequestMethod.GET)
    public void doManagement()
    {
        // NTD
    }

}
