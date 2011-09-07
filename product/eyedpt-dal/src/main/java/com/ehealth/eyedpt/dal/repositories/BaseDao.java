/*
 * Created on 2011-8-8
 */

package com.ehealth.eyedpt.dal.repositories;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

/**
 * Abstract base implementation of {code IDAO}.
 * 
 * @author emac
 */
@Transactional
public abstract class BaseDao<T>
        implements IDao<T>
{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(T object)
    {
        this.em.persist(object);
        this.em.flush();
    }

    @Override
    public T update(T object)
    {
        T merged = this.em.merge(object);
        this.em.flush();

        return merged;
    }

    @Override
    public void delete(T object)
    {
        T attached = this.em.merge(object);
        this.em.remove(attached);
        this.em.flush();
    }

    /**
     * Attempts to return a single result. Return {@code null} if there's no result (swallow
     * {@code EntityNotFoundException}).
     * 
     * @param query
     * @return
     */
    public T getSingleResult(Query query)
    {
        try
        {
            return (T) query.getSingleResult();
        }
        catch (NoResultException e)
        {
            return null;
        }
    }

}
