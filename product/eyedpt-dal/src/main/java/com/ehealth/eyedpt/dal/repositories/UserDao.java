/*
 * Created on 2011-7-30
 */

package com.ehealth.eyedpt.dal.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ehealth.eyedpt.dal.entities.User;

/**
 * @author emac
 */
@Repository
@Transactional
public class UserDao
        implements IDao<User>
{

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public User find(Long id)
    {
        return this.em.find(User.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll()
    {
        return this.em.createNamedQuery(User.QUERY_FIND_ALL).getResultList();
    }

    @Transactional(readOnly = true)
    public List<User> findByName(String name)
    {
        Query query = this.em.createNamedQuery(User.QUERY_FIND_BY_NAME);
        query.setParameter("name", name);

        return query.getResultList();
    }

    public void create(User user)
    {
        this.em.persist(user);
        this.em.flush();
    }

    public void update(User user)
    {
        User merged = this.em.merge(user);
        this.em.flush();
        
        user.setId(merged.getId());
    }

    public void delete(User user)
    {
        this.em.remove(user);
        this.em.flush();
    }

}
