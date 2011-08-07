/*
 * Created on 2011-8-7
 */

package com.ehealth.eyedpt.dal.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author emac
 */
@Entity(name = "doctorblob")
@Table(name = "doctorblob")
public class DoctorBlob
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long     id;

    @OneToOne(optional = false)
    @Column(name = "hospitalid", nullable = false)
    @NotNull
    private Hospital hospital;

    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[]   photo;

    @Lob
//    @Column(columnDefinition = "TEXT")
    @Column(columnDefinition = "CLOB")
    private String   description;

    /**
     * @return the id
     */
    public long getId()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id)
    {
        this.id = id;
    }

    /**
     * @return the hospital
     */
    public Hospital getHospital()
    {
        return hospital;
    }

    /**
     * @param hospital the hospital to set
     */
    public void setHospital(Hospital hospital)
    {
        this.hospital = hospital;
    }

    /**
     * @return the photo
     */
    public byte[] getPhoto()
    {
        return photo;
    }

    /**
     * @param photo the photo to set
     */
    public void setPhoto(byte[] photo)
    {
        this.photo = photo;
    }

    /**
     * @return the description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

}
