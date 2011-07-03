/*
 * Created on 2011-7-2
 */

package org.seeeye.ems.restlet.resources;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.data.MediaType;
import org.restlet.ext.freemarker.TemplateRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import org.seeeye.dal.dao.DaoFactory;
import org.seeeye.dal.dao.EmployeeDao;
import org.seeeye.dal.entities.Employee;
import org.seeeye.ems.freemarker.MyConfiguration;
import org.seeeye.ems.restlet.Constants;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * @author emac
 */
public class EmsResource extends ServerResource
{

    private static final Logger logger = Logger.getLogger(EmsResource.class.getName());

    private EmployeeDao         empDao;
    private Configuration       fmConfig;

    public EmsResource()
    {
        this.empDao = (EmployeeDao) DaoFactory.getInstance().getDao(EmployeeDao.class);
        this.fmConfig = MyConfiguration.getInstance().getConfiguration();
    }

    @Get
    public Representation doGet()
    {
        try
        {
            Template template = this.fmConfig.getTemplate(Constants.TEMPLATE_EMS);

            List<Employee> emps = this.empDao.findAll();
            HashMap root = new HashMap();
            root.put("employees", emps);

            return new TemplateRepresentation(template, root, MediaType.TEXT_HTML);
        }
        catch (IOException e)
        {
            logger.log(Level.SEVERE, "Failed to retrieve employee information", e);

            return new StringRepresentation(e.getLocalizedMessage());
        }
    }

    @Post
    Representation doPost(Representation entity)
    {
        return doGet();
    }

}
