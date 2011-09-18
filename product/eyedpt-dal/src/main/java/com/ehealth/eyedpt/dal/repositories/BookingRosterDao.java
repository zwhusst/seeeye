/*
 * Created on 2011-9-18
 */

package com.ehealth.eyedpt.dal.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ehealth.eyedpt.dal.entities.BookingRoster;
import com.ehealth.eyedpt.dal.entities.Doctor;

/**
 * @author emac
 */
@Repository
@Transactional
public class BookingRosterDao extends BaseDao<BookingRoster>
{

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<BookingRoster> findAll()
    {
        return this.em.createNamedQuery(BookingRoster.QUERY_FIND_ALL).getResultList();
    }

    /**
     * @param doctor
     * @return
     */
    @Transactional(readOnly = true)
    public List<BookingRoster> findByDoctor(Doctor doctor)
    {
        Query query = this.em.createNamedQuery(BookingRoster.QUERY_FIND_BY_DOCTOR);
        query.setParameter("doctor", doctor);

        return query.getResultList();
    }

}
