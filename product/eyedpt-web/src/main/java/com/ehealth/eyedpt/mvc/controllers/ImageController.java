/*
 * Created on 2011-9-12
 */

package com.ehealth.eyedpt.mvc.controllers;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ehealth.eyedpt.com.vogoal.util.img.RandImgCreater;
import com.ehealth.eyedpt.mvc.constants.SessionConstants;

/**
 * @author emac
 */
@Controller
public class ImageController
{

    private static Logger      logger            = Logger.getLogger(ImageController.class);

    public static final String MAPPING_CHECKCODE = "/images/checkcode";

    @RequestMapping(MAPPING_CHECKCODE)
    public void genCheckcode(HttpServletResponse response, HttpSession session)
    {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        RandImgCreater creator = new RandImgCreater(response);
        String checkcode = creator.createRandImage();
        session.setAttribute(SessionConstants.ATTR_CHECKCODE, checkcode);

        logger.info("Checkcode generated!");
    }

}
