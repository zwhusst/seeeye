/*
 * Created on 2011-9-13
 */

package com.ehealth.eyedpt.mvc.services;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Wraps {@code JavaMailSender} to provide basic mail service.
 * 
 * @author emac
 */
@Service
public class MailService
{

    private static Logger       logger       = Logger.getLogger(MailService.class);

    private static final String DEFAULT_FROM = "emac.ehealth@ttdong.com.cn";

    @Autowired
    private JavaMailSender      mailSender;

    /**
     * Sends a simple text mail to the given address.
     * 
     * @param to
     * @param text
     */
    public void sendSimpleTextMail(String to, String subject, String text)
    {
        if ( StringUtils.isEmpty(to) || StringUtils.isEmpty(text) )
        {
            return;
        }

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(DEFAULT_FROM);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        this.mailSender.send(message);

        logger.info("Sent mail to " + to + " successfully!");
    }

}
