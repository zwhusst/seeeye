/*
 * Created on 2011-7-2
 */

package org.seeeye.ems.restlet.resources;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.data.Form;
import org.restlet.data.MediaType;
import org.restlet.ext.freemarker.TemplateRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import org.seeeye.dal.dao.DaoFactory;
import org.seeeye.dal.dao.EmployeeDao;
import org.seeeye.dal.entities.Employee;
import org.seeeye.dal.entities.Employee.Gender;
import org.seeeye.dal.entities.Employee.Title;
import org.seeeye.ems.freemarker.MyConfiguration;
import org.seeeye.ems.restlet.Constants;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * @author emac
 */
public class EmployeeResource extends ServerResource
{

    private static final Logger logger = Logger.getLogger(EmployeeResource.class.getName());

    private EmployeeDao         empDao;
    private Configuration       fmConfig;

    public EmployeeResource()
    {
        this.empDao = (EmployeeDao) DaoFactory.getInstance().getDao(EmployeeDao.class);
        this.fmConfig = MyConfiguration.getInstance().getConfiguration();
    }

    @Get
    public Representation doGet()
    {
        try
        {
            Template template = this.fmConfig.getTemplate(Constants.TEMPLATE_EMPLOYEE);

            Object empId = getEmployeeId();
            Employee emp = this.empDao.find(empId);
            HashMap root = new HashMap();
            root.put("employee", emp);

            return new TemplateRepresentation(template, root, MediaType.TEXT_HTML);
        }
        catch (IOException e)
        {
            logger.log(Level.SEVERE, "Failed to retrieve employee information", e);

            return new StringRepresentation(e.getLocalizedMessage());
        }
    }

    @Post
    public void doPost(Representation entity)
    {
        Form form = new Form(entity);
        Object id = getEmployeeId();

        // name
        String name = form.getFirstValue(Constants.PARAM_EMP_NAME);

        // TODO#EMAC.P1 turn gender into radio buttons, add validation on age, turn title/manager into lists
        // gender
        Gender gender = Gender.valueOf(form.getFirstValue(Constants.PARAM_EMP_GENDER));

        // age
        Integer age = Integer.valueOf(form.getFirstValue(Constants.PARAM_EMP_AGE));

        // title
        Title title = Title.valueOf(form.getFirstValue(Constants.PARAM_EMP_TITLE));

        // manager
        Employee emp = this.empDao.find(id);
        Object mid = emp.getManager() == null ? null : emp.getManager().getId();

        this.empDao.update(id, name, gender, age, title, mid);

        // redirect to EMS
        getResponse().redirectPermanent(getRootRef().addSegment(Constants.SEGMENT_EMS));
    }

    @Delete
    public void doDelete()
    {
        Object empId = getEmployeeId();
        this.empDao.delete(empId);
    }

    private Object getEmployeeId()
    {
        return getRequestAttributes().get(Constants.ATTRIBUTE_EMP_ID);
    }

}
