/*
 * Created on 2011-8-7
 */

package com.ehealth.eyedpt.mvc.messages;

/**
 * Bound message source: /META-INF/messages/validation.properties.
 * 
 * @author emac
 */
public interface ValidationMessages
{

    // User
    public static final String VA_USER_NAME_EMPTY          = "VA_USER_NAME_EMPTY";
    public static final String VA_USER_PASSWORD_WRONG      = "VA_USER_PASSWORD_WRONG";
    public static final String VA_USER_NAME_EXIST          = "VA_USER_NAME_EXIST";
    public static final String VA_USER_NAME_NOT_EXIST      = "VA_USER_NAME_NOT_EXIST";

    // Change Password
    public static final String VA_CHANGEPWD_PASSWORD_WRONG = "VA_CHANGEPWD_PASSWORD_WRONG";

    // Checkcode
    public static final String VA_CHECKCODE_NOT_MATCH      = "VA_CHECKCODE_NOT_MATCH";

}
