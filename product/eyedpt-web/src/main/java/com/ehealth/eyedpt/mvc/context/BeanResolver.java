/*
 * Created on 2011-8-9
 */

package com.ehealth.eyedpt.mvc.context;

import org.springframework.context.ApplicationContext;

/**
 * A utility class to resolve spring beans outside spring context.
 * 
 * @author emac
 */
public class BeanResolver
{

    private static ApplicationContext appContext;

    private BeanResolver()
    {
        // disable external initialization
    }

    /**
     * @return
     */
    public static ApplicationContext getApplicationContext()
    {
        return appContext;
    }

    /**
     * @param appContext
     */
    public static void setApplicationContext(ApplicationContext appContext)
    {
        BeanResolver.appContext = appContext;
    }

    /**
     * Returns the bean instance that uniquely matches the given object type, if any.
     * 
     * @param clazz
     * @return
     */
    public static <T> T getBean(Class<T> clazz)
    {
        return appContext.getBean(clazz);
    }

}
