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
     * Doctor CRUD
     */
    DOCTOR_C(0), DOCTOR_R(1), DOCTOR_U(2), DOCTOR_D(3),
    /**
     * Booking CRUD
     */
    BOOKING_C(4), BOOKING_R(5), BOOKING_U(6), BOOKING_D(7),
    /**
     * Consulting CRUD
     */
    CONSULTING_C(8), CONSULTING_R(9), CONSULTING_U(10), CONSULTING_D(11);

    public int idx;

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
