/*
 * Created on 2011-6-28
 */

package org.seeeye.dal.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.seeeye.dal.entities.Employee;
import org.seeeye.dal.entities.Employee.Gender;
import org.seeeye.dal.entities.Employee.Title;

/**
 * @author emac
 */
public class EmployeeDaoTests
{

    private static EmployeeDao dao;

    @BeforeClass
    public static void setUp()
    {
        dao = (EmployeeDao) DaoFactory.getInstance().getDao(EmployeeDao.class);
    }

    @Test
    public void testDeleteAll()
    {
        for (Employee e : dao.findAll())
        {
            dao.delete(e.getId());
        }

        Assert.assertEquals(dao.findAll().size(), 0);
    }

    @Test
    public void testCreate()
    {
        int oldSize = dao.findAll().size();
        dao.create("ceo", Gender.M, 40, Title.CEO, null);
        int newSize = dao.findAll().size();

        Assert.assertEquals(newSize, oldSize + 1);
    }

    @Test
    public void testUpdate()
    {
        List<Employee> emps = dao.findAll();
        if ( emps.size() == 0 )
        {
            dao.create("ceo", Gender.M, 40, Title.CEO, null);
            emps = dao.findAll();
        }

        Employee emp = emps.get(0);
        int oldAge = emp.getAge();
        dao.update(emp.getId(), emp.getName(), emp.getGender(), emp.getAge() + 1, emp.getTitle(),
                emp.getManager() == null ? null : emp.getManager().getId());
        int newAge = dao.find(emp.getId()).getAge();

        Assert.assertEquals(newAge, oldAge + 1);
    }

}
