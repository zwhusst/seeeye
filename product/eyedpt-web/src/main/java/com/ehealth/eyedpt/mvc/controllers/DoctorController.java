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
import com.ehealth.eyedpt.dal.entities.Doctor;
import com.ehealth.eyedpt.dal.entities.User;
import com.ehealth.eyedpt.mvc.components.MessageSourceProvider;
import com.ehealth.eyedpt.mvc.constants.FormConstants;
import com.ehealth.eyedpt.mvc.constants.SessionConstants;
import com.ehealth.eyedpt.mvc.form.models.DoctorBean;
import com.ehealth.eyedpt.mvc.messages.ValidationMessages;
import com.ehealth.eyedpt.mvc.services.DoctorService;
import com.ehealth.eyedpt.mvc.services.UserService;

/**
 * @author emac
 */
@Controller
public class DoctorController
{

    private static Logger         logger           = Logger.getLogger(DoctorController.class);

    public static final String    MAPPING_MGMT     = "/doctor/mgmt";
    public static final String    MAPPING_REGISTER = "/doctor/register";
    public static final String    MAPPING_EDIT     = "/doctor/edit";

    @Autowired
    private UserService           userService;

    @Autowired
    private DoctorService         doctorService;

    @Autowired
    private RoleService           roleService;

    @Autowired
    private MessageSourceProvider msp;

    @RequestMapping(value = MAPPING_MGMT, method = RequestMethod.GET)
    @PreAuthorize("hasRole('DOCTOR_ADMIN')")
    public void doManagement()
    {
        // NTD
    }

    @RequestMapping(value = MAPPING_MGMT, method = RequestMethod.DELETE)
    @PreAuthorize("hasRole('DOCTOR_ADMIN')")
    public void doDelete(@RequestParam String employeeId)
    {
        if ( StringUtils.isEmpty(employeeId) )
        {
            logger.error("The employee ID of doctor to be deleted cannot be empty!");

            return;
        }

        Doctor doctor = this.doctorService.findByEmployeeId(employeeId);
        if ( doctor == null )
        {
            logger.error("Unable to find doctor whose employ ID is '" + employeeId + "'");

            return;
        }

        this.doctorService.delete(doctor);

        logger.info("Doctor deleted: " + employeeId);
    }

    @RequestMapping(value = MAPPING_REGISTER, method = RequestMethod.GET)
    @PreAuthorize("hasRole('DOCTOR_ADMIN')")
    public void doRegister(Model model)
    {
        model.addAttribute(new DoctorBean());
    }

    @RequestMapping(value = MAPPING_REGISTER, method = RequestMethod.POST)
    @PreAuthorize("hasRole('DOCTOR_ADMIN')")
    public String doRegister(@Valid DoctorBean doctorBean, BindingResult result)
    {
        if ( result.hasErrors() )
        {
            return null;
        }

        User user = this.userService.findByName(doctorBean.getName());
        if ( user != null )
        {
            result.addError(new FieldError(FormConstants.BEAN_DOCTOR, FormConstants.FIELD_NAME, this.msp
                    .getMessage(ValidationMessages.VA_USER_NAME_EXIST)));

            return null;
        }

        this.doctorService.createDoctor(doctorBean);

        logger.info("New doctor registered: " + doctorBean.getName());

        return "redirect:" + MAPPING_MGMT;
    }

    @RequestMapping(value = MAPPING_EDIT, method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public void doEdit(HttpSession session, Model model, @RequestParam(required = false) String employeeId)
    {
        // create new bean
        User user = (User) session.getAttribute(SessionConstants.ATTR_USER);
        Assert.notNull(user);

        Doctor doctor = null;
        if ( !StringUtils.isEmpty(employeeId) )
        {
            // route from management page
            Assert.isTrue(this.roleService.isGrantedRole(user, Role.DOCTOR_ADMIN));

            doctor = this.doctorService.findByEmployeeId(employeeId);
        }
        else
        {
            doctor = this.doctorService.findByUser(user);
        }

        Assert.notNull(doctor);

        DoctorBean doctorBean = DoctorBean.fromEntity(doctor);
        model.addAttribute(doctorBean);
    }

    @RequestMapping(value = MAPPING_EDIT, method = RequestMethod.POST)
    @PreAuthorize("isAuthenticated()")
    public String doEdit(@Valid DoctorBean doctorBean, BindingResult result,
            @RequestParam(required = false) String employeeId)
    {
        if ( result.hasErrors() )
        {
            return null;
        }

        this.doctorService.updateDoctor(doctorBean);

        logger.info("Doctor updated: " + doctorBean.getName());

        if ( !StringUtils.isEmpty(employeeId) )
        {
            // route from management page
            return "redirect:" + MAPPING_MGMT;
        }

        return "redirect:/";
    }

}
