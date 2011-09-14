/*
 * Created on 2011-9-8
 */

package com.ehealth.eyedpt.mvc.services;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehealth.eyedpt.dal.entities.Doctor;
import com.ehealth.eyedpt.dal.entities.DoctorBlob;
import com.ehealth.eyedpt.dal.repositories.DoctorBlobDao;
import com.ehealth.eyedpt.mvc.form.models.DoctorBean;

/**
 * @author emac
 */
@Service
public class DoctorBlobService
{

    @Autowired
    private DoctorBlobDao doctorBlobDao;

    /**
     * @param doctor
     * @return
     */
    public DoctorBlob findByDoctor(Doctor doctor)
    {
        return this.doctorBlobDao.findByDoctor(doctor);
    }

    /**
     * @param doctor
     * @param bean
     * @return
     */
    DoctorBlob create(Doctor doctor, DoctorBean bean)
    {
        DoctorBlob blob = null;
        // double check
        if ( shouldCreate(bean) )
        {
            blob = new DoctorBlob();
            blob.setDoctor(doctor);
            blob.setPhoto(bean.getPhoto());
            blob.setDescription(bean.getDescription());
            this.doctorBlobDao.create(blob);
        }

        return blob;
    }

    /**
     * @param doctor
     * @param bean
     * @return
     */
    DoctorBlob update(Doctor doctor, DoctorBean bean)
    {
        DoctorBlob blob = this.doctorBlobDao.findByDoctor(doctor);
        if ( blob == null )
        {
            if ( shouldCreate(bean) )
            {
                blob = create(doctor, bean);
            }
        }
        else
        {
            if ( bean.getPhoto() != null && bean.getPhoto().length > 0 )
            {
                blob.setPhoto(bean.getPhoto());
            }
            blob.setDescription(bean.getDescription());
            this.doctorBlobDao.update(blob);
        }

        return blob;
    }

    /**
     * Since it's expensive to create blob row, only create one on demand.
     * 
     * @param bean
     * @return
     */
    public boolean shouldCreate(DoctorBean bean)
    {
        return !ArrayUtils.isEmpty(bean.getPhoto()) || !StringUtils.isEmpty(bean.getDescription());
    }

}
