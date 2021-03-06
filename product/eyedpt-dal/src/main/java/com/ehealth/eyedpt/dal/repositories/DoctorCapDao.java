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

import com.ehealth.eyedpt.dal.entities.Doctor;
import com.ehealth.eyedpt.dal.entities.DoctorCap;

/**
 * @author emac
 */
@Repository
@Transactional
public class DoctorCapDao extends BaseDao<DoctorCap>
{

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<DoctorCap> findAll()
    {
        return this.em.createNamedQuery(DoctorCap.QUERY_FIND_ALL).getResultList();
    }

    /**
     * @param doctor
     * @return
     */
    @Transactional(readOnly = true)
    public DoctorCap findByDoctor(Doctor doctor)
    {
        Query query = this.em.createNamedQuery(DoctorCap.QUERY_FIND_BY_DOCTOR);
        query.setParameter("doctor", doctor);

        return getSingleResult(query);
    }

}
