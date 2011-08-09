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

    public T find(long id);

    public List<T> findAll();

    public void create(T object);

    public void update(T object);

    public void delete(T object);

}
