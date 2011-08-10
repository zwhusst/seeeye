/*
 * Created on 2011-8-8
 */

package com.ehealth.eyedpt.dal.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    public void update(T object)
    {
        this.em.merge(object);
        this.em.flush();
    }

    @Override
    public void delete(T object)
    {
        this.em.remove(object);
        this.em.flush();
    }

}
