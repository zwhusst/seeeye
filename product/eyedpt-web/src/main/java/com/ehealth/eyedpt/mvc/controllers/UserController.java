/*
 * Created on 2011-8-2
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

import com.ehealth.eyedpt.core.security.services.AuthenticationService;
import com.ehealth.eyedpt.dal.entities.User;
import com.ehealth.eyedpt.mvc.components.MessageSourceProvider;
import com.ehealth.eyedpt.mvc.constants.FormConstants;
import com.ehealth.eyedpt.mvc.constants.SessionConstants;
import com.ehealth.eyedpt.mvc.form.models.ChangePwdBean;
import com.ehealth.eyedpt.mvc.messages.ValidationMessages;
import com.ehealth.eyedpt.mvc.services.UserService;

/**
 * @author emac
 */
@Controller
public class UserController
{

    private static Logger         logger        = Logger.getLogger(UserController.class);

    public static final String    MAPPING_CHPWD = "/profile/changepwd";

    @Autowired
    private UserService           userService;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private MessageSourceProvider msp;

    @RequestMapping(value = MAPPING_CHPWD, method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public void doChangePwd(Model model)
    {
        model.addAttribute(new ChangePwdBean());
    }

    @RequestMapping(value = MAPPING_CHPWD, method = RequestMethod.POST)
    @PreAuthorize("isAuthenticated()")
    public String doChangePwd(@Valid ChangePwdBean bean, BindingResult result, HttpSession session)
    {
        if ( result.hasErrors() )
        {
            return null;
        }

        User user = (User) session.getAttribute(SessionConstants.ATTR_USER);
        Assert.notNull(user);

        if ( !bean.getPassword().equals(user.getPassword()) )
        {
            result.addError(new FieldError(FormConstants.BEAN_CHANGEPWD, FormConstants.FIELD_PASSWORD, this.msp
                    .getMessage(ValidationMessages.VA_CHANGEPWD_PASSWORD_WRONG)));

            return null;
        }

        user.setPassword(bean.getNewPassword());
        user = this.userService.update(user);
        
        session.setAttribute(SessionConstants.ATTR_USER, user);

        // update spring authentication
        this.authenticationService.resetAuthentication(user);

        logger.info("Password changed: " + user.getName());

        return "redirect:/";
    }

}
