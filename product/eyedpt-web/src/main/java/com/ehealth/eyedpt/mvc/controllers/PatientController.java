/*
 * Created on 2011-8-10
 */

package com.ehealth.eyedpt.mvc.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ehealth.eyedpt.dal.entities.Patient;
import com.ehealth.eyedpt.dal.entities.User;
import com.ehealth.eyedpt.mvc.components.MessageSourceProvider;
import com.ehealth.eyedpt.mvc.constants.FormConstants;
import com.ehealth.eyedpt.mvc.constants.SessionConstants;
import com.ehealth.eyedpt.mvc.form.models.PatientBean;
import com.ehealth.eyedpt.mvc.messages.ValidationMessages;
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
    private MessageSourceProvider msd;

    @RequestMapping(value = MAPPING_REGISTER, method = RequestMethod.GET)
    public void doRegister(Model model)
    {
        model.addAttribute(new PatientBean());
    }

    @RequestMapping(value = MAPPING_REGISTER, method = RequestMethod.POST)
    public String doRegister(@Valid PatientBean patientBean, BindingResult result, HttpSession session)
    {
        if ( result.hasErrors() )
        {
            return null;
        }

        User user = this.userService.findUserByName(patientBean.getName());
        if ( user != null )
        {
            result.addError(new FieldError(FormConstants.BEAN_PATIENT, FormConstants.FIELD_NAME, this.msd
                    .getMessage(ValidationMessages.VA_USER_NAME_EXIST)));

            return null;
        }

        Patient patient = this.patientService.createPatient(patientBean);
        session.setAttribute(SessionConstants.ATTR_USER, patient.getUser());

        logger.info("New patient registered!");

        return "redirect:/";
    }

    @RequestMapping(value = MAPPING_EDIT, method = RequestMethod.GET)
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
    public String doEdit(@Valid PatientBean patientBean, BindingResult result, HttpSession session)
    {
        if ( result.hasErrors() )
        {
            return null;
        }

        Patient patient = this.patientService.updatePatient(patientBean);
        session.setAttribute(SessionConstants.ATTR_USER, patient.getUser());

        logger.info("Patient updated!");

        return "redirect:/";
    }

}
