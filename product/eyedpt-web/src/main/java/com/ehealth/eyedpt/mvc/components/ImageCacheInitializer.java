/*
 * Created on 2011-9-11
 */

package com.ehealth.eyedpt.mvc.components;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

import javax.servlet.ServletContext;

import org.apache.commons.lang.ArrayUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.WebUtils;

import com.ehealth.eyedpt.core.cache.images.ImageCache;
import com.ehealth.eyedpt.core.cache.images.ImageCacheManager;
import com.ehealth.eyedpt.dal.entities.DoctorBlob;
import com.ehealth.eyedpt.dal.repositories.DoctorBlobDao;
import com.ehealth.eyedpt.mvc.constants.Constants;
import com.ehealth.eyedpt.mvc.constants.ImageConstants;

/**
 * Initializes image cache service.
 * 
 * @author emac
 */
@Component
public class ImageCacheInitializer
{

    private static Logger       logger                  = Logger.getLogger(ImageCacheInitializer.class);

    private static final String DEFAULT_CACHE_BASE_PATH = "/resources";

    @Autowired
    private ImageCache          imageCache;

    @Autowired
    private ImageCacheManager   imageCacheManager;

    @Autowired
    private DoctorBlobDao       doctorBlobDao;

    /**
     * @param appContext
     */
    public void init(ApplicationContext appContext)
    {
        initImageCache(appContext);
        initImageCacheManager(appContext);
    }

    private void initImageCache(ApplicationContext appContext)
    {
        if ( !(appContext instanceof WebApplicationContext) )
        {
            return;
        }

        try
        {
            WebApplicationContext webContext = (WebApplicationContext) appContext;
            ServletContext servletContext = webContext.getServletContext();
            String basePath = WebUtils.getRealPath(servletContext, DEFAULT_CACHE_BASE_PATH);
            this.imageCache.setCacheBaseDir(new File(basePath));

            logger.info("ImageCache initialized!");
        }
        catch (Exception e)
        {
            logger.error("Error occurs when initializing ImageCache!", e);
        }
    }

    private void initImageCacheManager(ApplicationContext appContext)
    {
        try
        {
            // system images
            Resource resource = appContext.getResource(ImageConstants.IMAGE_ANONYMOUS_USER);
            if ( resource != null && resource.exists() )
            {
                this.imageCacheManager.put(Constants.ANONYMOUS_USER_NAME, resource.getInputStream());
            }

            // doctor photos
            for (DoctorBlob blob : this.doctorBlobDao.findAll())
            {
                if ( ArrayUtils.isEmpty(blob.getPhoto()) )
                {
                    continue;
                }

                String userName = blob.getDoctor().getUser().getName();
                InputStream photoInputStream = new ByteArrayInputStream(blob.getPhoto());
                this.imageCacheManager.put(userName, photoInputStream);
            }

            logger.info("ImageCache initialized!");
        }
        catch (Exception e)
        {
            logger.error("Error occurs when initializing ImageCache!", e);
        }
    }

}
