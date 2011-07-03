/*
 * Created on 2011-6-27
 */

package org.seeeye.dal.dao;

import java.util.List;

/**
 * @author emac
 */
public interface IDao<T>
{

    public T find(Object eid);

    public List<T> findAll();

}
