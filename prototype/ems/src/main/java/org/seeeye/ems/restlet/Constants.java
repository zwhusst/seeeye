/*
 * Created on 2011-7-3
 */

package org.seeeye.ems.restlet;

/**
 * @author emac
 */
public interface Constants
{

    public String ATTRIBUTE_SERVLET_CONTEXT = "org.restlet.ext.servlet.ServletContext";

    public String ATTRIBUTE_EMP_ID          = "employee.id";

    public String SEGMENT_EMS               = "employees";
    public String URL_PATTERN_EMS           = "/" + SEGMENT_EMS;
    public String URL_PATTERN_EMPLOYEE      = URL_PATTERN_EMS + "/{" + ATTRIBUTE_EMP_ID + "}";

    public String TEMPLATE_EMS              = "management.ftl";
    public String TEMPLATE_EMPLOYEE         = "employee.ftl";

    public String PARAM_EMP_ID              = "id";
    public String PARAM_EMP_NAME            = "name";
    public String PARAM_EMP_GENDER          = "gender";
    public String PARAM_EMP_AGE             = "age";
    public String PARAM_EMP_TITLE           = "title";
    public String PARAM_EMP_MANAGER         = "manager";

}
