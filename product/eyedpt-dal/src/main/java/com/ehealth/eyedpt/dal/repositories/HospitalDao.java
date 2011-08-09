/*
 * Created on 2011-8-8
 */

package com.ehealth.eyedpt.dal.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    public Hospital find(long id)
    {
        return this.em.find(Hospital.class, id);
    }

    @Override
    public List<Hospital> findAll()
    {
        return this.em.createNamedQuery(Hospital.QUERY_FIND_ALL).getResultList();
    }

}
