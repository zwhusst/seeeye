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
import com.ehealth.eyedpt.dal.entities.User;

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

    /**
     * @param user
     * @return
     */
    @Transactional(readOnly = true)
    public Doctor findByUser(User user)
    {
        Query query = this.em.createNamedQuery(Doctor.QUERY_FIND_BY_USER);
        query.setParameter("user", user);

        return getSingleResult(query);
    }

}
