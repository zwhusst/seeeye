/*
 * Created on 2011-9-12
 */

package com.ehealth.eyedpt.mvc.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ehealth.eyedpt.core.cache.images.ImageCache;
import com.ehealth.eyedpt.mvc.services.CheckcodeService;

/**
 * @author emac
 */
@Controller
public class ImageController
{

    private static Logger      logger            = Logger.getLogger(ImageController.class);

    public static final String MAPPING_CHECKCODE = "/images/checkcode";
    public static final String MAPPING_PROFILE   = "/images/profile/{imageName}";

    @Autowired
    private ImageCache         imageCache;

    @Autowired
    private CheckcodeService   checkcodeService;

    @RequestMapping(value = MAPPING_CHECKCODE, method = RequestMethod.GET)
    public @ResponseBody
    void genCheckcode(HttpServletResponse response, HttpSession session)
    {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        this.checkcodeService.genCheckcode(response, session);

        logger.info("Checkcode generated!");
    }

    @RequestMapping(value = MAPPING_PROFILE, method = RequestMethod.GET)
    public @ResponseBody
    void getProfileImage(@PathVariable String imageName, HttpServletResponse response)
            throws FileNotFoundException, IOException
    {
        if ( StringUtils.isEmpty(imageName) )
        {
            return;
        }

        File image = new File(this.imageCache.getCacheDir(), imageName);
        if ( !image.isFile() )
        {
            return;
        }

        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        IOUtils.copy(new FileInputStream(image), response.getOutputStream());

        logger.info("Profile image retrieved!");
    }
}
