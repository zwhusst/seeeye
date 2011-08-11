/*
 * Created on 2011-8-8
 */

package com.ehealth.eyedpt.dal.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ehealth.eyedpt.dal.entities.Doctor;

/**
 * @author emac
 */
@Repository
@Transactional
public class DoctorDao extends BaseDao<Doctor>
{

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<Doctor> findAll()
    {
        return this.em.createNamedQuery(Doctor.QUERY_FIND_ALL).getResultList();
    }

}
