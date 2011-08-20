/*
 * Created on 2011-8-8
 */

package com.ehealth.eyedpt.dal.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ehealth.eyedpt.dal.entities.Department;
import com.ehealth.eyedpt.dal.entities.Hospital;

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
    @Transactional(readOnly = true)
    public List<Department> findAll()
    {
        return this.em.createNamedQuery(Department.QUERY_FIND_ALL).getResultList();
    }

    /**
     * @param hospital
     * @param name
     * @return
     */
    public Department findByHospitalAndName(Hospital hospital, String name)
    {
        Query query = this.em.createNamedQuery(Department.QUERY_FIND_BY_HOSPTIAL_AND_NAME);
        query.setParameter("hospital", hospital);
        query.setParameter("name", name);

        return getSingleResult(query);
    }

}
