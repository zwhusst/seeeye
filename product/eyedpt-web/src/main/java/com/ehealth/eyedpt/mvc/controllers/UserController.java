/*
 * Created on 2011-8-2
 */

package com.ehealth.eyedpt.mvc.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ehealth.eyedpt.dal.entities.User;
import com.ehealth.eyedpt.mvc.components.MessageSourceProvider;
import com.ehealth.eyedpt.mvc.constants.SessionConstants;
import com.ehealth.eyedpt.mvc.messages.ValidationMessages;
import com.ehealth.eyedpt.mvc.services.UserService;

/**
 * @author emac
 */
@Controller
public class UserController
{

    private static Logger         logger           = Logger.getLogger(UserController.class);

    public static final String    MAPPING_LOGIN    = "/login";
    public static final String    MAPPING_LOGOUT   = "/logout";

    @Autowired
    private UserService           userService;

    @Autowired
    private MessageSourceProvider msd;

    @RequestMapping(value = MAPPING_LOGIN, method = RequestMethod.POST, params = "login")
    public String doLogin(@RequestParam String name, @RequestParam String password, HttpSession session)
    {
        if ( StringUtils.isEmpty(name) )
        {
            session.setAttribute(SessionConstants.ATTRIBUTE_MESSAGE,
                    this.msd.getMessage(ValidationMessages.VA_USER_NAME_EMPTY));

            return "redirect:/";
        }

        List<User> users = this.userService.findUserByName(name);
        if ( users.size() == 0 )
        {
            session.setAttribute(SessionConstants.ATTRIBUTE_MESSAGE,
                    this.msd.getMessage(ValidationMessages.VA_USER_NAME_NONEXIST));

            return "redirect:/";
        }

        User user = users.get(0);
        if ( !StringUtils.equals(password, user.getPassword()) )
        {
            session.setAttribute(SessionConstants.ATTRIBUTE_MESSAGE,
                    this.msd.getMessage(ValidationMessages.VA_USER_PASSWORD_WRONG));

            return "redirect:/";
        }

        session.setAttribute(SessionConstants.ATTRIBUTE_USER, user);
        logger.info("Logged in!");

        return "redirect:/";
    }

    @RequestMapping(MAPPING_LOGOUT)
    public String doLogout(HttpSession session)
    {
        session.setAttribute(SessionConstants.ATTRIBUTE_USER, null);
        logger.info("Logged out!");

        return "redirect:/";
    }

}
