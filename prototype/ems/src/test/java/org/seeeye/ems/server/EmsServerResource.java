/*
 * Created on 2011-6-29
 */

package org.seeeye.ems.server;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import org.seeeye.dal.dao.DaoFactory;
import org.seeeye.dal.dao.EmployeeDao;
import org.seeeye.dal.entities.Employee;
import org.seeeye.dal.entities.Employee.Gender;
import org.seeeye.dal.entities.Employee.Title;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * @author emac
 */
public class EmsServerResource extends ServerResource
{

    private Configuration fmConfig;
    private EmployeeDao   empDao;

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args)
            throws Exception
    {
        new Server(Protocol.HTTP, 8182, EmsServerResource.class).start();
    }

    public EmsServerResource() throws URISyntaxException, IOException
    {
        this.fmConfig = new Configuration();
        File templatesDir = new File(getClass().getResource("/templates").toURI());
        this.fmConfig.setDirectoryForTemplateLoading(templatesDir);
        this.fmConfig.setObjectWrapper(new DefaultObjectWrapper());

        this.empDao = (EmployeeDao) DaoFactory.getInstance().getDao(EmployeeDao.class);
    }

    @Get
    public String getIndexPage()
            throws IOException, TemplateException
    {
        List<Employee> emps = this.empDao.findAll();
        if ( emps.size() == 0 )
        {
            this.empDao.create("ceo", Gender.M, 40, Title.CEO, null);
            emps = this.empDao.findAll();
        }
        Employee emp = emps.get(0);

        HashMap root = new HashMap();
        root.put("employee", emp);

        Template template = this.fmConfig.getTemplate("index.ftl");
        StringWriter writer = new StringWriter();
        template.process(root, writer);

        return writer.toString();
    }

}
