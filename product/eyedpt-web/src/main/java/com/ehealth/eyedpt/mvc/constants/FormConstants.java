/*
 * Created on 2011-8-6
 */

package com.ehealth.eyedpt.mvc.constants;

/**
 * @author emac
 */
public interface FormConstants
{

    public static final int[]    AGE_RANGE                  = new int[]
                                                            { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
            17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43,
            44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70,
            71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97,
            98, 99                                          };

    public static final String[] DEGREE_RANGE               = new String[]
                                                            { "博士", "硕士", "学士", "无"};

    public static final String[] EDUCATION_RANGE            = new String[]
                                                            { "博士研究生", "硕士研究生", "大学本科", "大学专科"};

    /**
     * User
     */
    public static final String   BEAN_PATIENT               = "patientBean";
    public static final String   BEAN_ADMIN                 = "adminBean";
    public static final String   BEAN_DOCTOR                = "doctorBean";

    public static final String   FIELD_NAME                 = "name";
    public static final String   FIELD_PASSWORD             = "password";
    public static final String   FIELD_USERGROUP            = "usergroup";
    // admin only
    public static final String   FIELD_ROLESET              = "roleset";
    // shared
    public static final String   FIELD_REAL_NAME            = "realname";
    public static final String   FIELD_BIRTHDAY             = "birthday";
    public static final String   FIELD_AGE                  = "age";
    public static final String   FIELD_GENDER               = "gender";
    public static final String   FIELD_EMAIL                = "email";
    public static final String   FIELD_CELLPHONE            = "cellphone";
    public static final String   FIELD_TELEPHONE            = "telephone";
    // patient only
    public static final String   FIELD_PROVINCE             = "province";
    public static final String   FIELD_CITY                 = "city";
    public static final String   FIELD_REG_TYPE             = "registrytype";
    public static final String   FIELD_REG_NO               = "registryno";
    public static final String   FIELD_FAX                  = "faxno";
    // doctor only
    public static final String   FIELD_ADDRESS              = "address";
    public static final String   FIELD_EMPLOYEE_ID          = "employeeid";
    public static final String   FIELD_TITLE                = "title";
    public static final String   FIELD_ADMIN_TITLE          = "admintitle";
    public static final String   FIELD_EXPERT_RANK          = "expertrank";
    public static final String   FIELD_FIRST_RECRUIT        = "firstrecruit";
    public static final String   FIELD_LAST_PROMOTE         = "lastpromote";
    public static final String   FIELD_SPECIALITIES         = "specialities";
    public static final String   FIELD_COLLEAGE             = "colleage";
    public static final String   FIELD_MAJOR                = "major";
    public static final String   FIELD_SECOND_MAJOR         = "secondmajor";
    public static final String   FIELD_DEGREE               = "degree";
    public static final String   FIELD_EDUCATION            = "education";
    public static final String   FIELD_SUPERVISOR_TYPE      = "supervisortype";
    public static final String   FIELD_SUPERVISIOR_COLLEGES = "supervisiorcolleges";
    public static final String   FIELD_PHOTO                = "photo";
    public static final String   FIELD_DESCRIPTION          = "description";

    /**
     * Change Password
     */
    public static final String   BEAN_CHANGEPWD             = "changePwdBean";
    public static final String   FIELD_NEW_PASSWORD         = "newPassword";

    /**
     * Forgot Password
     */
    public static final String   BEAN_FORGOTPWD             = "forgotPwdBean";

}
