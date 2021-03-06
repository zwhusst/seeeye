/*
 * Created on 2011-8-10
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
import org.springframework.web.bind.annotation.RequestParam;

import com.ehealth.eyedpt.core.security.services.AuthenticationService;
import com.ehealth.eyedpt.dal.entities.Patient;
import com.ehealth.eyedpt.dal.entities.User;
import com.ehealth.eyedpt.mvc.components.MessageSourceProvider;
import com.ehealth.eyedpt.mvc.constants.FormConstants;
import com.ehealth.eyedpt.mvc.constants.SessionConstants;
import com.ehealth.eyedpt.mvc.constants.ViewConstants;
import com.ehealth.eyedpt.mvc.form.models.PatientBean;
import com.ehealth.eyedpt.mvc.messages.ValidationMessages;
import com.ehealth.eyedpt.mvc.services.CheckcodeService;
import com.ehealth.eyedpt.mvc.services.PatientService;
import com.ehealth.eyedpt.mvc.services.UserService;

/**
 * @author emac
 */
@Controller
public class PatientController
{

    private static Logger         logger           = Logger.getLogger(PatientController.class);

    public static final String    MAPPING_REGISTER = "/patient/register";
    public static final String    MAPPING_EDIT     = "/patient/edit";

    @Autowired
    private UserService           userService;

    @Autowired
    private PatientService        patientService;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private CheckcodeService      checkcodeService;

    @Autowired
    private MessageSourceProvider msp;

    @RequestMapping(value = MAPPING_REGISTER, method = RequestMethod.GET)
    @PreAuthorize("isAnonymous()")
    public void doRegister(Model model)
    {
        model.addAttribute(new PatientBean());
    }

    @RequestMapping(value = MAPPING_REGISTER, method = RequestMethod.POST)
    @PreAuthorize("isAnonymous()")
    public String doRegister(@Valid PatientBean bean, BindingResult result, HttpSession session,
            @RequestParam String checkcode)
    {
        // check checkcode
        if ( !this.checkcodeService.checkCheckcode(checkcode, session) )
        {
            return null;
        }

        User user = this.userService.findByName(bean.getName());
        if ( user != null )
        {
            result.addError(new FieldError(FormConstants.BEAN_PATIENT, FormConstants.FIELD_NAME, this.msp
                    .getMessage(ValidationMessages.VA_USER_NAME_EXIST)));
        }

        if ( result.hasErrors() )
        {
            return null;
        }

        Patient patient = this.patientService.create(bean);
        user = patient.getUser();
        session.setAttribute(SessionConstants.ATTR_USER, user);

        // update spring authentication
        this.authenticationService.resetAuthentication(user);

        logger.info("New patient registered: " + bean.getName());

        return ViewConstants.REDIRECT_HOME;
    }

    @RequestMapping(value = MAPPING_EDIT, method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public void doEdit(HttpSession session, Model model)
    {
        // create new bean
        User user = (User) session.getAttribute(SessionConstants.ATTR_USER);
        Assert.notNull(user);

        Patient patient = this.patientService.findByUser(user);
        Assert.notNull(patient);

        PatientBean patientBean = PatientBean.fromEntity(patient);
        model.addAttribute(patientBean);
    }

    @RequestMapping(value = MAPPING_EDIT, method = RequestMethod.POST)
    @PreAuthorize("isAuthenticated()")
    public String doEdit(@Valid PatientBean bean, BindingResult result)
    {
        if ( result.hasErrors() )
        {
            return null;
        }

        this.patientService.update(bean);

        logger.info("Patient updated: " + bean.getName());

        return ViewConstants.REDIRECT_HOME;
    }

}
