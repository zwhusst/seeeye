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
import org.springframework.web.bind.annotation.RequestParam;

import com.ehealth.eyedpt.core.security.services.AuthenticationService;
import com.ehealth.eyedpt.dal.entities.User;
import com.ehealth.eyedpt.mvc.components.MessageSourceProvider;
import com.ehealth.eyedpt.mvc.constants.FormConstants;
import com.ehealth.eyedpt.mvc.constants.SessionConstants;
import com.ehealth.eyedpt.mvc.constants.ViewConstants;
import com.ehealth.eyedpt.mvc.form.models.ChangePwdBean;
import com.ehealth.eyedpt.mvc.form.models.ForgotPwdBean;
import com.ehealth.eyedpt.mvc.messages.ValidationMessages;
import com.ehealth.eyedpt.mvc.services.CheckcodeService;
import com.ehealth.eyedpt.mvc.services.UserService;

/**
 * @author emac
 */
@Controller
public class UserController
{

    private static Logger         logger        = Logger.getLogger(UserController.class);

    public static final String    MAPPING_CHPWD = "/profile/changepwd";
    public static final String    MAPPING_FGPWD = "/profile/forgotpwd";

    @Autowired
    private UserService           userService;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private CheckcodeService      checkcodeService;

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

        return ViewConstants.REDIRECT_HOME;
    }

    @RequestMapping(value = MAPPING_FGPWD, method = RequestMethod.GET)
    @PreAuthorize("!isAuthenticated()")
    public void doForgotPwd(Model model)
    {
        model.addAttribute(new ForgotPwdBean());
    }

    @RequestMapping(value = MAPPING_FGPWD, method = RequestMethod.POST)
    @PreAuthorize("!isAuthenticated()")
    public void doForgotPwd(@Valid ForgotPwdBean bean, BindingResult result, HttpSession session,
            @RequestParam String checkcode)
    {
        // check checkcode
        if ( !this.checkcodeService.checkCheckcode(checkcode, session) )
        {
            return;
        }

        if ( result.hasErrors() )
        {
            return;
        }

        User user = this.userService.findByName(bean.getName());
        if ( user == null )
        {
            result.addError(new FieldError(FormConstants.BEAN_FORGOTPWD, FormConstants.FIELD_NAME, this.msp
                    .getMessage(ValidationMessages.VA_USER_NAME_NOT_EXIST)));

            return;
        }

        session.setAttribute(SessionConstants.RESULT_FORGOTPWD, Boolean.TRUE);

        logger.info("Password sent to user's mailbox: " + bean.getName());
    }

}
