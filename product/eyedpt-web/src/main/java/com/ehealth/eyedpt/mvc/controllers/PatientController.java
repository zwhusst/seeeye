/*
 * Created on 2011-8-10
 */

package com.ehealth.eyedpt.mvc.controllers;

import java.util.List;

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

    public static final String    MAPPING_REGISTER = "/register/patient";

    @Autowired
    private UserService           userService;

    @Autowired
    private PatientService        patientService;

    @Autowired
    private MessageSourceProvider msd;

    @RequestMapping(value = MAPPING_REGISTER, method = RequestMethod.GET)
    public void doRegister(HttpSession session, Model model)
    {
        PatientBean patientBean = (PatientBean) session.getAttribute(SessionConstants.ATTRIBUTE_PATIENT);
        model.addAttribute(patientBean != null ? patientBean : new PatientBean());
    }

    @RequestMapping(value = MAPPING_REGISTER, method = RequestMethod.POST)
    public String doRegister(@Valid PatientBean patientBean, BindingResult result, HttpSession session)
    {
        if ( result.hasErrors() )
        {
            return null;
        }

        List<User> users = this.userService.findUserByName(patientBean.getName());
        if ( users.size() > 0 )
        {
            result.addError(new FieldError(FormConstants.BEAN_PATIENT, FormConstants.FIELD_NAME, this.msd
                    .getMessage(ValidationMessages.VA_USER_NAME_EXIST)));

            return null;
        }

        this.patientService.createPatient(patientBean);

        users = this.userService.findUserByName(patientBean.getName());
        Assert.isTrue(users.size() == 1);
        session.setAttribute(SessionConstants.ATTRIBUTE_USER, users.get(0));

        logger.info("Registered!");

        return "redirect:/";
    }

}
