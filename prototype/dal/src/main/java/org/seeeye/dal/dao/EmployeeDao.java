/*
 * Created on 2011-6-27
 */

package org.seeeye.dal.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.seeeye.dal.entities.Employee;
import org.seeeye.dal.entities.Employee.Gender;
import org.seeeye.dal.entities.Employee.Title;

/**
 * @author emac
 */
public class EmployeeDao
        implements IDao<Employee>
{

    private EntityManager em = MyEntityManager.getInstance().getEntityManager();

    EmployeeDao()
    {

    }

    public Employee find(Object eid)
    {
        return this.em.find(Employee.class, eid);
    }

    public Employee findByName(String name)
    {
        Query query = this.em.createNamedQuery(Employee.QUERY_FIND_BY_NAME);
        query.setParameter(1, name);

        return (Employee) query.getSingleResult();
    }

    public List<Employee> findAll()
    {
        Query query = this.em.createNamedQuery(Employee.QUERY_FIND_ALL);

        return query.getResultList();
    }

    public void create(String name, Gender gender, int age, Title title, Object mid)
    {
        Employee emp = new Employee();
        emp.setName(name);
        emp.setGender(gender);
        emp.setAge(age);
        emp.setTitle(title);
        emp.setManager(find(mid));

        begin();
        this.em.persist(emp);
        commit();
    }

    public void update(Object eid, String name, Gender gender, int age, Title title, Object mid)
    {
        Employee emp = find(eid);
        if ( emp == null )
        {
            return;
        }

        emp.setName(name);
        emp.setGender(gender);
        emp.setAge(age);
        emp.setTitle(title);
        emp.setManager(find(mid));

        begin();
        this.em.merge(emp);
        commit();
    }

    public void delete(Object eid)
    {
        Employee emp = find(eid);
        if ( emp == null )
        {
            return;
        }

        begin();
        this.em.remove(emp);
        commit();
    }

    private void begin()
    {
        this.em.getTransaction().begin();
    }

    private void commit()
    {
        this.em.getTransaction().commit();
    }

    public static void main(String[] args)
    {
        EmployeeDao dao = new EmployeeDao();
        dao.create("John", Gender.M, 40, Title.CEO, null);
        Employee john = dao.findByName("John");

        dao.create("Spark", Gender.M, 35, Title.MANAGER, john.getId());
        Employee spark = dao.findByName("Spark");

        dao.create("Emac", Gender.M, 30, Title.EMPLOYEE, spark.getId());
    }

}
