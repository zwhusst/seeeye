/*
 * Created on 2011-8-20
 */

package com.ehealth.eyedpt.mvc.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.ehealth.eyedpt.core.security.Role;
import com.ehealth.eyedpt.core.security.services.RoleService;
import com.ehealth.eyedpt.dal.entities.Admin;
import com.ehealth.eyedpt.dal.entities.User;
import com.ehealth.eyedpt.mvc.components.MessageSourceProvider;
import com.ehealth.eyedpt.mvc.constants.FormConstants;
import com.ehealth.eyedpt.mvc.constants.SessionConstants;
import com.ehealth.eyedpt.mvc.constants.ViewConstants;
import com.ehealth.eyedpt.mvc.form.models.AdminBean;
import com.ehealth.eyedpt.mvc.messages.ValidationMessages;
import com.ehealth.eyedpt.mvc.services.AdminService;
import com.ehealth.eyedpt.mvc.services.UserService;
import com.ehealth.eyedpt.mvc.utils.CharsetUtils;

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

    @Autowired
    private UserService           userService;

    @Autowired
    private AdminService          adminService;

    @Autowired
    private RoleService           roleService;

    @Autowired
    private MessageSourceProvider msp;

    @RequestMapping(value = MAPPING_MGMT, method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN_ADMIN')")
    public void doManagement()
    {
        // NTD
    }

    @RequestMapping(value = MAPPING_MGMT, method = RequestMethod.DELETE)
    @PreAuthorize("hasRole('ADMIN_ADMIN')")
    public void doDelete(@RequestParam String userName)
    {
        if ( StringUtils.isEmpty(userName) )
        {
            logger.error("The name of admin to be deleted cannot be empty!");

            return;
        }

        userName = CharsetUtils.translate(userName);
        User user = this.userService.findByName(userName);
        Admin admin = this.adminService.findByUser(user);
        Assert.notNull(admin);

        this.adminService.delete(admin);

        logger.info("Admin deleted: " + userName);
    }

    @RequestMapping(value = MAPPING_REGISTER, method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN_ADMIN')")
    public void doRegister(Model model)
    {
        model.addAttribute(new AdminBean());
    }

    @RequestMapping(value = MAPPING_REGISTER, method = RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN_ADMIN')")
    public String doRegister(@Valid AdminBean bean, BindingResult result)
    {
        User user = this.userService.findByName(bean.getName());
        if ( user != null )
        {
            result.addError(new FieldError(FormConstants.BEAN_ADMIN, FormConstants.FIELD_NAME, this.msp
                    .getMessage(ValidationMessages.VA_USER_NAME_EXIST)));
        }

        if ( result.hasErrors() )
        {
            return null;
        }

        this.adminService.create(bean);

        logger.info("New admin registered: " + bean.getName());

        return "redirect:" + MAPPING_MGMT;
    }

    @RequestMapping(value = MAPPING_EDIT, method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public void doEdit(HttpSession session, Model model, @RequestParam(required = false) String userName)
    {
        // create new bean
        User user = (User) session.getAttribute(SessionConstants.ATTR_USER);
        if ( !StringUtils.isEmpty(userName) )
        {
            // route from management page
            Assert.isTrue(this.roleService.isGrantedRole(user, Role.ADMIN_ADMIN));

            userName = CharsetUtils.translate(userName);
            user = this.userService.findByName(userName);
        }
        Assert.notNull(user);

        Admin admin = this.adminService.findByUser(user);
        Assert.notNull(admin);

        AdminBean adminBean = AdminBean.fromEntity(admin);
        model.addAttribute(adminBean);
    }

    @RequestMapping(value = MAPPING_EDIT, method = RequestMethod.POST)
    @PreAuthorize("isAuthenticated()")
    public String doEdit(@Valid AdminBean bean, BindingResult result, @RequestParam(required = false) String username)
    {
        if ( result.hasErrors() )
        {
            return null;
        }

        this.adminService.update(bean);

        logger.info("Admin updated: " + bean.getName());

        if ( !StringUtils.isEmpty(username) )
        {
            // route from management page
            return "redirect:" + MAPPING_MGMT;
        }

        return ViewConstants.REDIRECT_HOME;
    }

}
