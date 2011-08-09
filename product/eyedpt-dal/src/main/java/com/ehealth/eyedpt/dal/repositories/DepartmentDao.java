/*
 * Created on 2011-8-8
 */

package com.ehealth.eyedpt.dal.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ehealth.eyedpt.dal.entities.Department;

/**
 * @author emac
 */
@Repository
@Transactional
public class DepartmentDao extends BaseDao<Department>
{

    @PersistenceContext
    private EntityManager em;

    @Override
    public Department find(long id)
    {
        return this.em.find(Department.class, id);
    }

    @Override
    public List<Department> findAll()
    {
        return this.em.createNamedQuery(Department.QUERY_FIND_ALL).getResultList();
    }

}
