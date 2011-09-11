/*
 * Created on 2011-8-10
 */

package com.ehealth.eyedpt.mvc.components;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

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

    private static Logger         logger = Logger.getLogger(ContextInitializer.class);

    @Autowired
    private ImageCacheInitializer imageCacheInitializer;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        initBeanResolver(event.getApplicationContext());
        initImageCache(event.getApplicationContext());
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

    private void initImageCache(ApplicationContext appContext)
    {
        this.imageCacheInitializer.init(appContext);
    }

}
