/*
 * Created on 2011-8-8
 */

package com.ehealth.eyedpt.dal.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ehealth.eyedpt.dal.entities.Patient;

/**
 * @author emac
 */
@Repository
@Transactional
public class PatientDao extends BaseDao<Patient>
{

    @PersistenceContext
    private EntityManager em;

    @Override
    public Patient find(long id)
    {
        return this.em.find(Patient.class, id);
    }

    @Override
    public List<Patient> findAll()
    {
        return this.em.createNamedQuery(Patient.QUERY_FIND_ALL).getResultList();
    }

}
