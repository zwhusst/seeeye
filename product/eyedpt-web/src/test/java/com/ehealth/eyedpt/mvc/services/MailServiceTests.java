/*
 * Created on 2011-9-13
 */

package com.ehealth.eyedpt.mvc.services;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * @author emac
 */
@ContextConfiguration("classpath:WEB-INF/spring/context-servlet-test.xml")
public class MailServiceTests extends AbstractJUnit4SpringContextTests
{

    private static final String TEST_TO = "emac.ehealth@ttdong.com.cn";

    @Autowired
    private MailService         mailService;

    @Test
    public void testSendSimpleTextMail()
    {
//        this.mailService.sendSimpleTextMail(TEST_TO, "Greeting", "Hello, Emac!");
    }

}
