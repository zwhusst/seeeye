/*
 * Created on 2011-8-2
 */

package com.ehealth.eyedpt.mvc.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ehealth.eyedpt.dal.entities.User;
import com.ehealth.eyedpt.mvc.services.UserService;

/**
 * @author emac
 */
@Controller
@RequestMapping("/login")
public class LoginController
{

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public void doGet(HttpSession session, Model model)
    {
        User user = (User) session.getAttribute("user");
        model.addAttribute(user != null ? user : new User());
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(@RequestParam String name, @RequestParam String password, HttpSession session)
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
        if ( StringUtils.equals(password, user.getPassword()) )
        {
            session.setAttribute("user", user);
            System.out.println("Logged in!");
        }

        return "redirect:/";
    }

}
