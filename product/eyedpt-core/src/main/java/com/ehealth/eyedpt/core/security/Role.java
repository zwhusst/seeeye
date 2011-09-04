/*
 * Created on 2011-8-17
 */

package com.ehealth.eyedpt.core.security;

/**
 * @author emac
 */
public enum Role
{

    /**
     * Patient Management
     */
    PATIENT_ADMIN(0),
    /**
     * Doctor Management
     */
    DOCTOR_ADMIN(1),
    /**
     * Admin Management
     */
    ADMIN_ADMIN(2),
    /**
     * Booking Management
     */
    BOOKING_ADMIN(8),
    /**
     * Blacklist Management
     */
    BLACKLIST_ADMIN(9),
    /**
     * Consulting Management
     */
    CONSULTING_ADMIN(12);

    public static final byte REVOKED = 0;
    public static final byte GRANTED = 1;

    public int               idx;

    private Role(int idx)
    {
        this.idx = idx;
    }

    /**
     * Returns the enum constant of the given index.
     * 
     * @param idx
     * @return
     */
    public static Role valueOf(int idx)
    {
        for (Role r : values())
        {
            if ( idx == r.idx )
            {
                return r;
            }
        }

        return null;
    }

}
