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

import com.ehealth.eyedpt.dal.entities.Admin;
import com.ehealth.eyedpt.dal.entities.User;

/**
 * @author emac
 */
@Repository
@Transactional
public class AdminDao extends BaseDao<Admin>
{

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<Admin> findAll()
    {
        return this.em.createNamedQuery(Admin.QUERY_FIND_ALL).getResultList();
    }

    /**
     * @param user
     * @return
     */
    @Transactional(readOnly = true)
    public Admin findByUser(User user)
    {
        Query query = this.em.createNamedQuery(Admin.QUERY_FIND_BY_USER);
        query.setParameter("user", user);

        return getSingleResult(query);
    }

}
