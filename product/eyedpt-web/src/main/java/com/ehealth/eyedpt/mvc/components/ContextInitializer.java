/*
 * Created on 2011-8-10
 */

package com.ehealth.eyedpt.mvc.components;

import java.io.File;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.WebUtils;

import com.ehealth.eyedpt.core.cache.images.ImageCache;
import com.ehealth.eyedpt.mvc.context.BeanResolver;

/**
 * Initializes core components/services/utility classes.
 * 
 * @author emac
 */
@Component
public class ContextInitializer
        implements ApplicationListener<ContextRefreshedEvent>
{

    private static Logger logger = Logger.getLogger(ContextInitializer.class);

    @Autowired
    private ImageCache    imageCache;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        initBeanResolver(event.getApplicationContext());
        initImageCacheManager(event.getApplicationContext());
    }

    private void initBeanResolver(ApplicationContext appContext)
    {
        if ( BeanResolver.getApplicationContext() == null )
        {
            BeanResolver.setApplicationContext(appContext);
            logger.info("BeanResolver initialized!");
        }
        else
        {
            logger.warn("BeanResolver has already been initialized!");
        }
    }

    private void initImageCacheManager(ApplicationContext appContext)
    {
        if ( !(appContext instanceof WebApplicationContext) )
        {
            return;
        }

        try
        {
            WebApplicationContext webContext = (WebApplicationContext) appContext;
            ServletContext servletContext = webContext.getServletContext();
            String resourcesPath = WebUtils.getRealPath(servletContext, "/resources");
            this.imageCache.setCacheBaseDir(new File(resourcesPath));
            logger.info("ImageCache initialized!");
        }
        catch (Exception e)
        {
            logger.error("Error occurs when initializing ImageCache!");
        }
    }

}
