/*
 * Created on 2011-8-7
 */

package com.ehealth.eyedpt.dal.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author emac
 */
@Entity(name = "doctorblob")
@Table(name = "doctorblob")
@NamedQueries(
{
        @NamedQuery(name = DoctorBlob.QUERY_FIND_ALL, query = "select d from doctorblob d"),
        @NamedQuery(name = DoctorBlob.QUERY_FIND_BY_DOCTOR, query = "select d from doctorblob d where d.doctor=:doctor")})
public class DoctorBlob
{

    public static final String QUERY_FIND_ALL       = "FindAllDoctorBlobs";
    public static final String QUERY_FIND_BY_DOCTOR = "FindAdminByDoctor";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long               id;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @Column(name = "doctorid", nullable = false)
    @NotNull
    private Doctor             doctor;

    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[]             photo;

    @Lob
//    @Column(columnDefinition = "TEXT")
    @Column(columnDefinition = "CLOB")
    private String             description;

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
     * @return the doctor
     */
    public Doctor getDoctor()
    {
        return this.doctor;
    }

    /**
     * @param doctor the doctor to set
     */
    public void setDoctor(Doctor doctor)
    {
        this.doctor = doctor;
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
