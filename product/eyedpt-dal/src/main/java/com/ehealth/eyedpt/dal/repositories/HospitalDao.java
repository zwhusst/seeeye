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

import com.ehealth.eyedpt.dal.entities.Hospital;

/**
 * @author emac
 */
@Repository
@Transactional
public class HospitalDao extends BaseDao<Hospital>
{

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<Hospital> findAll()
    {
        return this.em.createNamedQuery(Hospital.QUERY_FIND_ALL).getResultList();
    }

    /**
     * @param name
     * @return
     */
    @Transactional(readOnly = true)
    public Hospital findByName(String name)
    {
        Query query = this.em.createNamedQuery(Hospital.QUERY_FIND_BY_NAME);
        query.setParameter("name", name);

        return getSingleResult(query);
    }

}
