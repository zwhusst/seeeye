/*
 * Created on 2011-8-20
 */

package com.ehealth.eyedpt.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehealth.eyedpt.dal.repositories.DoctorDao;

/**
 * @author emac
 */
@Service
public class DoctorService
{

    @Autowired
    private DoctorDao doctorDao;

}
