/*
 * Created on 2011-8-20
 */

package com.ehealth.eyedpt.mvc.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ehealth.eyedpt.dal.entities.Admin;
import com.ehealth.eyedpt.dal.entities.User;
import com.ehealth.eyedpt.mvc.components.MessageSourceProvider;
import com.ehealth.eyedpt.mvc.constants.FormConstants;
import com.ehealth.eyedpt.mvc.constants.SessionConstants;
import com.ehealth.eyedpt.mvc.form.models.AdminBean;
import com.ehealth.eyedpt.mvc.messages.ValidationMessages;
import com.ehealth.eyedpt.mvc.services.AdminService;
import com.ehealth.eyedpt.mvc.services.UserService;

/**
 * @author emac
 */
@Controller
public class AdminController
{

    private static Logger         logger           = Logger.getLogger(AdminController.class);

    public static final String    MAPPING_MGMT     = "/admin/mgmt";
    public static final String    MAPPING_REGISTER = "/admin/register";
    public static final String    MAPPING_EDIT     = "/admin/edit";
    public static final String    MAPPING_DELETE   = "/admin/delete";

    @Autowired
    private UserService           userService;

    @Autowired
    private AdminService          adminService;

    @Autowired
    private MessageSourceProvider msp;

    @RequestMapping(value = MAPPING_MGMT, method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN_ADMIN')")
    public void doManagement()
    {
        // NTD
    }

    @RequestMapping(value = MAPPING_REGISTER, method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN_ADMIN')")
    public void doRegister(Model model)
    {
        model.addAttribute(new AdminBean());
    }

    @RequestMapping(value = MAPPING_REGISTER, method = RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN_ADMIN')")
    public String doRegister(@Valid AdminBean adminBean, BindingResult result)
    {
        if ( result.hasErrors() )
        {
            return null;
        }

        User user = this.userService.findByName(adminBean.getName());
        if ( user != null )
        {
            result.addError(new FieldError(FormConstants.BEAN_ADMIN, FormConstants.FIELD_NAME, this.msp
                    .getMessage(ValidationMessages.VA_USER_NAME_EXIST)));

            return null;
        }

        this.adminService.createAdmin(adminBean);

        logger.info("New admin registered: " + adminBean.getName());

        return "redirect:" + MAPPING_MGMT;
    }

    @RequestMapping(value = MAPPING_EDIT, method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public void doEdit(HttpSession session, Model model)
    {
        // create new bean
        User user = (User) session.getAttribute(SessionConstants.ATTR_USER);
        Assert.notNull(user);

        Admin admin = this.adminService.findByUser(user);
        Assert.notNull(admin);

        AdminBean adminBean = AdminBean.fromEntity(admin);
        model.addAttribute(adminBean);
    }

    @RequestMapping(value = MAPPING_EDIT, method = RequestMethod.POST)
    @PreAuthorize("isAuthenticated()")
    public String doEdit(@Valid AdminBean adminBean, BindingResult result, HttpSession session)
    {
        if ( result.hasErrors() )
        {
            return null;
        }

        Admin admin = this.adminService.updateAdmin(adminBean);
        session.setAttribute(SessionConstants.ATTR_USER, admin.getUser());

        logger.info("Admin updated: " + adminBean.getName());

        return "redirect:/";
    }

}
