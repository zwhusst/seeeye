/*
 * Created on 2011-9-11
 */

package com.ehealth.eyedpt.mvc.utils;

import org.apache.commons.lang.StringUtils;

/**
 * @author emac
 */
public class ImageUtils
{

    public static final String PATTERN_ACCEPTABLE_IMAGE_TYPES = ".+\\.(jpg|jpeg|png|gif)$";

    /**
     * Checks if the given content type is an acceptable image type.
     * 
     * @param fileName
     * @return
     */
    public static boolean isAcceptableImageType(String fileName)
    {
        if ( StringUtils.isEmpty(fileName) )
        {
            return false;
        }

        return fileName.toLowerCase().matches(PATTERN_ACCEPTABLE_IMAGE_TYPES);
    }

}
