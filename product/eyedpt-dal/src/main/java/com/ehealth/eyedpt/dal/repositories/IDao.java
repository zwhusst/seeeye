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
     * @return
     */
    public T update(T object);

    /**
     * Deletes the given instance.
     * 
     * @param object
     */
    public void delete(T object);

}
