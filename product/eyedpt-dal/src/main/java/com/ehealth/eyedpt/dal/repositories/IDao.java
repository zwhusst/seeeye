/*
 * Created on 2011-7-30
 */

package com.ehealth.eyedpt.dal.repositories;

import java.util.List;

/**
 * @author emac
 */
public interface IDao<T>
{

    /**
     * Finds an instance with given id.
     * 
     * @param id
     * @return
     */
    public T find(long id);

    /**
     * Finds all instances.
     * 
     * @return
     */
    public List<T> findAll();

    /**
     * Creates a new instance.
     * 
     * @param object
     */
    public void create(T object);

    /**
     * Updates the given instance.
     * 
     * @param object
     */
    public void update(T object);

    /**
     * Deletes the given instance.
     * 
     * @param object
     */
    public void delete(T object);

}
