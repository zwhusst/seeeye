/*
 * Created on 2011-9-12
 */

package com.ehealth.eyedpt.mvc.services;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.ehealth.eyedpt.com.vogoal.util.img.RandImgCreater;
import com.ehealth.eyedpt.mvc.components.MessageSourceProvider;
import com.ehealth.eyedpt.mvc.constants.SessionConstants;
import com.ehealth.eyedpt.mvc.messages.ValidationMessages;

/**
 * Service to generate/verify checkcode.
 * 
 * @author emac
 */
@Service
public class CheckcodeService
{

    @Autowired
    private MessageSourceProvider msp;

    /**
     * Generates a new checkcode and adds it as a session attribute.
     * 
     * @param response
     * @param session
     */
    public void genCheckcode(HttpServletResponse response, HttpSession session)
    {
        Assert.notNull(response);
        Assert.notNull(session);

        RandImgCreater creator = new RandImgCreater(response);
        String checkcode = creator.createRandImage();
        session.setAttribute(SessionConstants.ATTR_CHECKCODE, checkcode);

        // clear previous message
        session.setAttribute(SessionConstants.MESSAGE_CHECKCODE, null);
    }

    /**
     * Checks the given checkcode and returns {@code true} if it matches the one in session. Otherwise, return
     * {@code false}.
     * 
     * @param checkcode
     * @param session
     * @return
     */
    public boolean checkCheckcode(String checkcode, HttpSession session)
    {
        Assert.notNull(session);

        // check checkcode
        if ( !StringUtils.equalsIgnoreCase(checkcode, (String) session.getAttribute(SessionConstants.ATTR_CHECKCODE)) )
        {
            session.setAttribute(SessionConstants.MESSAGE_CHECKCODE,
                    this.msp.getMessage(ValidationMessages.VA_CHECKCODE_NOT_MATCH));

            return false;
        }

        // clear previous message
        session.setAttribute(SessionConstants.MESSAGE_CHECKCODE, null);

        return true;
    }

}
