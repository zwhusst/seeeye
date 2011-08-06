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
import com.ehealth.eyedpt.dal.entities.User.UserGroup;
import com.ehealth.eyedpt.mvc.services.UserService;

/**
 * @author emac
 */
@Controller
public class UserController
{

    private static Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService   userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST, params = "login")
    public String doLogin(@RequestParam String name, @RequestParam String pwd, HttpSession session)
    {
        if ( StringUtils.isEmpty(name) )
        {
            return "redirect:/";
        }

        List<User> users = this.userService.findUserByName(name);
        if ( users.size() != 1 )
        {
            return "redirect:/";
        }

        User user = users.get(0);
        if ( StringUtils.equals(pwd, user.getPassword()) )
        {
            session.setAttribute("user", user);
            logger.info("Logged in!");
        }

        return "redirect:/";
    }

    @RequestMapping("/logout")
    public String doLogout(HttpSession session)
    {
        session.setAttribute("user", null);
        logger.info("Logged out!");

        return "redirect:/";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String doRegister()
    {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, params = "register")
    public String doRegister(@RequestParam String name, @RequestParam String pwd, HttpSession session)
    {
        if ( StringUtils.isEmpty(name) )
        {
            return "redirect:/";
        }
        
        if ( StringUtils.isEmpty(pwd) )
        {
            return "redirect:/";
        }

        List<User> users = this.userService.findUserByName(name);
        if ( users.size() > 0 )
        {
            return "redirect:/";
        }

        this.userService.createUser(name, pwd, UserGroup.PATIENT);

        users = this.userService.findUserByName(name);
        if ( users.size() == 1 )
        {
            session.setAttribute("user", users.get(0));
            logger.info("Registered!");
        }

        return "redirect:/";
    }

}
