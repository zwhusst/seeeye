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

    public T find(Long id);

    public List<T> findAll();

}
