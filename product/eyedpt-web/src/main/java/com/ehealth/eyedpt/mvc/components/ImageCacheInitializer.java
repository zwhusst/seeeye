/*
 * Created on 2011-9-11
 */

package com.ehealth.eyedpt.mvc.components;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.WebUtils;

import com.ehealth.eyedpt.core.cache.images.ImageCache;
import com.ehealth.eyedpt.core.cache.images.ImageCacheManager;
import com.ehealth.eyedpt.dal.entities.DoctorBlob;
import com.ehealth.eyedpt.dal.repositories.DoctorBlobDao;

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
        initImageCacheManager();
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

    private void initImageCacheManager()
    {
        try
        {
            for (DoctorBlob blob : this.doctorBlobDao.findAll())
            {
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
