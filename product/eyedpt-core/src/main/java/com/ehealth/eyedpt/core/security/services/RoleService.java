/*
 * Created on 2011-8-17
 */

package com.ehealth.eyedpt.core.security.services;

import static com.ehealth.eyedpt.core.security.Role.BOOKING_C;
import static com.ehealth.eyedpt.core.security.Role.BOOKING_D;
import static com.ehealth.eyedpt.core.security.Role.BOOKING_R;
import static com.ehealth.eyedpt.core.security.Role.BOOKING_U;
import static com.ehealth.eyedpt.core.security.Role.CONSULTING_C;
import static com.ehealth.eyedpt.core.security.Role.CONSULTING_D;
import static com.ehealth.eyedpt.core.security.Role.CONSULTING_R;
import static com.ehealth.eyedpt.core.security.Role.CONSULTING_U;
import static com.ehealth.eyedpt.core.security.Role.DOCTOR_C;
import static com.ehealth.eyedpt.core.security.Role.DOCTOR_D;
import static com.ehealth.eyedpt.core.security.Role.DOCTOR_R;
import static com.ehealth.eyedpt.core.security.Role.DOCTOR_U;

import org.springframework.stereotype.Service;

import com.ehealth.eyedpt.core.security.Role;
import com.ehealth.eyedpt.dal.entities.User;

/**
 * @author emac
 */
@Service
public class RoleService
{

    private static final Role[] DEFAULT_PATIENT_ROLESET    = new Role[]
                                                           { BOOKING_C, BOOKING_R, BOOKING_U, CONSULTING_C,
            CONSULTING_R, CONSULTING_U                     };

    private static final Role[] DEFAULT_DOCTOR_ROLESET     = new Role[]
                                                           { DOCTOR_R, DOCTOR_U, CONSULTING_R};

    private static final Role[] DEFAULT_ADMIN_ROLESET      = new Role[]
                                                           { DOCTOR_C, DOCTOR_R, DOCTOR_U, DOCTOR_D, BOOKING_R,
            BOOKING_U, CONSULTING_R, CONSULTING_U          };

    private static final Role[] DEFAULT_ROOT_ADMIN_ROLESET = new Role[]
                                                           { DOCTOR_C, DOCTOR_R, DOCTOR_U, DOCTOR_D, BOOKING_R,
            BOOKING_U, BOOKING_D, CONSULTING_R, CONSULTING_U, CONSULTING_D};

    /**
     * Grants default patient roles to the given user.
     * 
     * @param user
     */
    public void grantPatientRoleSet(User user)
    {
        grantRoleSet(user, DEFAULT_PATIENT_ROLESET);
    }

    /**
     * Grants default doctor roles to the given user.
     * 
     * @param user
     */
    public void grantDoctorRoleSet(User user)
    {
        grantRoleSet(user, DEFAULT_DOCTOR_ROLESET);
    }

    /**
     * Grants default admin roles to the given user.
     * 
     * @param user
     */
    public void grantAdminRoleSet(User user)
    {
        grantRoleSet(user, DEFAULT_ADMIN_ROLESET);
    }

    /**
     * Grants default admin(root) roles to the given user.
     * 
     * @param user
     */
    public void grantRootAdminRoleSet(User user)
    {
        grantRoleSet(user, DEFAULT_ROOT_ADMIN_ROLESET);
    }

    private void grantRoleSet(User user, Role[] roles)
    {
        byte[] roleset = user.getRoleset();
        for (Role role : roles)
        {
            roleset[role.idx] = 1;
        }
    }

}
