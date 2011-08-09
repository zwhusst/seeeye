/*
 * Created on 2011-8-8
 */

package com.ehealth.eyedpt.dal.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ehealth.eyedpt.dal.entities.DoctorService;

/**
 * @author emac
 */
@Repository
@Transactional
public class DoctorServiceDao extends BaseDao<DoctorService>
{

    @PersistenceContext
    private EntityManager em;

    @Override
    public DoctorService find(long id)
    {
        return this.em.find(DoctorService.class, id);
    }

    @Override
    public List<DoctorService> findAll()
    {
        return this.em.createNamedQuery(DoctorService.QUERY_FIND_ALL).getResultList();
    }

}
