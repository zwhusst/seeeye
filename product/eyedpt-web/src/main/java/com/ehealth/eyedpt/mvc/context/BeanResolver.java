/*
 * Created on 2011-8-9
 */

package com.ehealth.eyedpt.mvc.context;

import org.springframework.context.ApplicationContext;

/**
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
     * @param context
     */
    public static void setApplicationContext(ApplicationContext context)
    {
        appContext = context;
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
