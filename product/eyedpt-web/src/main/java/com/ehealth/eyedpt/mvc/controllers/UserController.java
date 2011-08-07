/*
 * Created on 2011-8-2
 */

package com.ehealth.eyedpt.mvc.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ehealth.eyedpt.dal.entities.User;
import com.ehealth.eyedpt.dal.entities.enums.UserGroup;
import com.ehealth.eyedpt.mvc.constants.FormConstants;
import com.ehealth.eyedpt.mvc.constants.SessionConstants;
import com.ehealth.eyedpt.mvc.messages.MessageConstants;
import com.ehealth.eyedpt.mvc.messages.MessageSourceService;
import com.ehealth.eyedpt.mvc.services.UserService;

/**
 * @author emac
 */
@Controller
public class UserController
{

    private static Logger        logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService          userService;

    @Autowired
    private MessageSourceService mss;

    @RequestMapping(value = "/login", method = RequestMethod.POST, params = "login")
    public String doLogin(@RequestParam String name, @RequestParam String password, HttpSession session)
    {
        if ( StringUtils.isEmpty(name) )
        {
            session.setAttribute(SessionConstants.ATTRIBUTE_MESSAGE,
                    this.mss.getMessage(MessageConstants.USER_NAME_EMPTY));

            return "redirect:/";
        }

        List<User> users = this.userService.findUserByName(name);
        if ( users.size() == 0 )
        {
            session.setAttribute(SessionConstants.ATTRIBUTE_MESSAGE,
                    this.mss.getMessage(MessageConstants.USER_NAME_NONEXIST));

            return "redirect:/";
        }

        User user = users.get(0);
        if ( !StringUtils.equals(password, user.getPassword()) )
        {
            session.setAttribute(SessionConstants.ATTRIBUTE_MESSAGE,
                    this.mss.getMessage(MessageConstants.USER_PASSWORD_WRONG));

            return "redirect:/";
        }

        session.setAttribute(SessionConstants.ATTRIBUTE_USER, user);
        logger.info("Logged in!");

        return "redirect:/";
    }

    @RequestMapping("/logout")
    public String doLogout(HttpSession session)
    {
        session.setAttribute(SessionConstants.ATTRIBUTE_USER, null);
        logger.info("Logged out!");

        return "redirect:/";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public void doRegister(HttpSession session, Model model)
    {
        User user = (User) session.getAttribute(SessionConstants.ATTRIBUTE_USER);
        model.addAttribute(user != null ? user : new User());
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, params = "register")
    public String doRegister(@Valid User user, BindingResult result, HttpSession session)
    {
        if ( result.hasErrors() )
        {
            return null;
        }

        String name = user.getName();
        String pwd = user.getPassword();

        List<User> users = this.userService.findUserByName(name);
        if ( users.size() > 0 )
        {
            result.addError(new FieldError(FormConstants.OBJECT_USER, FormConstants.FIELD_USER_NAME, this.mss
                    .getMessage(MessageConstants.USER_NAME_EXIST)));

            return null;
        }

        this.userService.createUser(name, pwd, UserGroup.PATIENT);

        users = this.userService.findUserByName(name);
        Assert.isTrue(users.size() == 1);

        session.setAttribute(SessionConstants.ATTRIBUTE_USER, users.get(0));
        logger.info("Registered!");

        return "redirect:/";
    }

}
