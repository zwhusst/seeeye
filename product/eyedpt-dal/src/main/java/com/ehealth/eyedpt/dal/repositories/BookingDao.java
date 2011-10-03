/*
 * Created on 2011-9-27
 */

package com.ehealth.eyedpt.dal.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ehealth.eyedpt.dal.entities.Booking;
import com.ehealth.eyedpt.dal.entities.Patient;
import com.ehealth.eyedpt.dal.entities.enums.BookingStatus;

/**
 * @author emac
 */
@Repository
@Transactional
public class BookingDao extends BaseDao<Booking>
{

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<Booking> findAll()
    {
        return this.em.createNamedQuery(Booking.QUERY_FIND_ALL).getResultList();
    }

    /**
     * @param patient
     * @return
     */
    @Transactional(readOnly = true)
    public List<Booking> findByPatient(Patient patient)
    {
        Query query = this.em.createNamedQuery(Booking.QUERY_FIND_BY_PATIENT);
        query.setParameter("patient", patient);

        return query.getResultList();
    }

    /**
     * @param status
     * @return
     */
    @Transactional(readOnly = true)
    public List<Booking> findByStatus(BookingStatus status)
    {
        Query query = this.em.createNamedQuery(Booking.QUERY_FIND_BY_STATUS);
        query.setParameter("status", status);

        return query.getResultList();
    }

    /**
     * @param bookingId
     * @return
     */
    @Transactional(readOnly = true)
    public Booking findByBookingId(Long bookingId)
    {
        Query query = this.em.createNamedQuery(Booking.QUERY_FIND_BY_BOOKING_ID);
        query.setParameter("bookingid", bookingId);

        return getSingleResult(query);
    }

}
