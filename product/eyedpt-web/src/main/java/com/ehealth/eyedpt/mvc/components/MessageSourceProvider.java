/*
 * Created on 2011-8-7
 */

package com.ehealth.eyedpt.mvc.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

/**
 * Wraps {@code MessageSource} to bypass {@code Locale} parameter.
 * 
 * @author emac
 */
@Component
public class MessageSourceProvider
{

    @Autowired
    private MessageSource messageSource;

    /**
     * @param code
     * @return
     */
    public String getMessage(String code)
    {
        return this.messageSource.getMessage(code, null, null);
    }

    /**
     * @param code
     * @param args
     * @return
     */
    public String getMessage(String code, Object[] args)
    {
        return this.messageSource.getMessage(code, args, null);
    }

}
