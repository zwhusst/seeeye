/*
 * Created on 2011-9-25
 */

package com.ehealth.eyedpt.dal.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ehealth.eyedpt.dal.entities.BookingEx;
import com.ehealth.eyedpt.dal.entities.Doctor;

/**
 * @author emac
 */
@Repository
@Transactional
public class BookingExDao extends BaseDao<BookingEx>
{

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<BookingEx> findAll()
    {
        Query query = this.em.createNamedQuery(BookingEx.QUERY_FIND_ALL);

        return query.getResultList();
    }

    /**
     * @param doctor
     * @return
     */
    @Transactional(readOnly = true)
    public BookingEx findByDoctor(Doctor doctor)
    {
        Query query = this.em.createNamedQuery(BookingEx.QUERY_FIND_BY_DOCTOR);
        query.setParameter("doctor", doctor);

        return getSingleResult(query);
    }

}
