/*
 * Created on 2011-6-29
 */

package org.seeeye.dal.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * @author emac
 */
public class DaoFactory
{

    private static DaoFactory       instance = new DaoFactory();

    private static Map<Class, IDao> daoMap;

    static
    {
        daoMap = new HashMap<Class, IDao>();
        daoMap.put(EmployeeDao.class, new EmployeeDao());
    }

    private DaoFactory()
    {
    }

    public static DaoFactory getInstance()
    {
        return instance;
    }

    public <T extends IDao> IDao getDao(Class<T> clazz)
    {
        return daoMap.get(clazz);
    }

}
