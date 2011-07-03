/*
 * Created on 2011-7-2
 */

package org.seeeye.ems.freemarker;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;

/**
 * @author emac
 */
public class MyConfiguration
{

    private static final Logger    logger         = Logger.getLogger(MyConfiguration.class.getName());

    private static final String    TEMPLATES_PATH = "/templates";

    private static MyConfiguration instance       = new MyConfiguration();

    private boolean                initialized;

    private Configuration          configuration;

    private MyConfiguration()
    {
    }

    public static MyConfiguration getInstance()
    {
        return instance;
    }

    public void initialize(ServletContext context)
    {
        try
        {
            this.configuration = new Configuration();
            this.configuration.setServletContextForTemplateLoading(context, TEMPLATES_PATH);
            this.configuration.setObjectWrapper(new DefaultObjectWrapper());

            this.initialized = true;
        }
        catch (Exception e)
        {
            logger.log(Level.SEVERE, "Failed to initialize FreeMarker configuration", e);
        }
    }

    public Configuration getConfiguration()
    {
        if ( !initialized )
        {
            throw new IllegalStateException("The FreeMarker configuration hasn't been initialized.");
        }

        return this.configuration;
    }

}
