/*
 * Created on 2011-8-2
 */

package com.ehealth.eyedpt.mvc.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ehealth.eyedpt.mvc.components.MessageSourceProvider;
import com.ehealth.eyedpt.mvc.services.UserService;

/**
 * @author emac
 */
@Controller
public class UserController
{

    private static Logger         logger        = Logger.getLogger(UserController.class);

    public static final String    MAPPING_CHPWD = "/profile/changepassword";

    @Autowired
    private UserService           userService;

    @Autowired
    private MessageSourceProvider msd;

}
