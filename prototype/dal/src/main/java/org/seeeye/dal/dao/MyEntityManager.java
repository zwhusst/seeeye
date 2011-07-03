/*
 * Created on 2011-6-27
 */

package org.seeeye.dal.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author emac
 */
public class MyEntityManager
{

    private static MyEntityManager instance;

    private EntityManager          em;

    private MyEntityManager()
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("EmployeeManagementSystem",
                System.getProperties());
        this.em = factory.createEntityManager();
    }

    public synchronized static MyEntityManager getInstance()
    {
        if ( instance == null )
        {
            instance = new MyEntityManager();
        }

        return instance;
    }

    public EntityManager getEntityManager()
    {
        return this.em;
    }

    public void close()
    {
        this.em.close();
    }

}
