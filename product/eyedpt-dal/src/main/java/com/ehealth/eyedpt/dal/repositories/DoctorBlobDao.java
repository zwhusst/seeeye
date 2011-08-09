/*
 * Created on 2011-8-8
 */

package com.ehealth.eyedpt.dal.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ehealth.eyedpt.dal.entities.DoctorBlob;

/**
 * @author emac
 */
@Repository
@Transactional
public class DoctorBlobDao extends BaseDao<DoctorBlob>
{

    @PersistenceContext
    private EntityManager em;

    @Override
    public DoctorBlob find(long id)
    {
        return this.em.find(DoctorBlob.class, id);
    }

    @Override
    public List<DoctorBlob> findAll()
    {
        return this.em.createNamedQuery(DoctorBlob.QUERY_FIND_ALL).getResultList();
    }

}
