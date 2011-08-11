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
public class UserDao extends BaseDao<User>
{

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll()
    {
        return this.em.createNamedQuery(User.QUERY_FIND_ALL).getResultList();
    }

    /**
     * @param name
     * @return
     */
    @Transactional(readOnly = true)
    public User findByName(String name)
    {
        Query query = this.em.createNamedQuery(User.QUERY_FIND_BY_NAME);
        query.setParameter("name", name);

        return getSingleResult(query);
    }

}
