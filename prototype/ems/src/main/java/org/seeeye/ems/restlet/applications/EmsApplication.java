/*
 * Created on 2011-7-2
 */

package org.seeeye.ems.restlet.applications;

import javax.servlet.ServletContext;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;
import org.seeeye.ems.freemarker.MyConfiguration;
import org.seeeye.ems.restlet.Constants;
import org.seeeye.ems.restlet.resources.EmployeeResource;
import org.seeeye.ems.restlet.resources.EmsResource;

/**
 * @author emac
 */
public class EmsApplication extends Application
{

    @Override
    public Restlet createInboundRoot()
    {
        // initialize FreeMarker
        ServletContext servletContxt = (ServletContext) getContext().getAttributes().get(
                Constants.ATTRIBUTE_SERVLET_CONTEXT);
        MyConfiguration.getInstance().initialize(servletContxt);

        // Create a router Restlet that routes each call to a new instance of HelloWorldResource.
        Router router = new Router(getContext());

        // Defines only one route
        router.attach(Constants.URL_PATTERN_EMS, EmsResource.class);
        router.attach(Constants.URL_PATTERN_EMPLOYEE, EmployeeResource.class);

        return router;
    }

}
