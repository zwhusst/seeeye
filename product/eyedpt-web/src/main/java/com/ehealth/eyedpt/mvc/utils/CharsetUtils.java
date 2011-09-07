/*
 * Created on 2011-9-7
 */

package com.ehealth.eyedpt.mvc.utils;

import java.io.UnsupportedEncodingException;

import org.apache.commons.lang.StringUtils;

/**
 * @author emac
 */
public class CharsetUtils
{

    public static final String CHARSET_ISO_8859_1     = "ISO-8859-1";
    public static final String CHARSET_UTF_8          = "UTF-8";

    public static final String DEFAULT_ENCODE_CHARSET = CHARSET_ISO_8859_1;
    public static final String DEFAULT_DECODE_CHARSET = CHARSET_UTF_8;

    /**
     * Encodes then decodes the given string with default charsets sequentially.
     * 
     * @param src
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String translate(String src)
    {
        try
        {
            return translate(src, DEFAULT_ENCODE_CHARSET, DEFAULT_DECODE_CHARSET);
        }
        catch (UnsupportedEncodingException e)
        {
            // safely ignore
            return src;
        }
    }

    /**
     * Encodes then decodes the given string with given charsets sequentially.
     * 
     * @param src
     * @param encodeCharset
     * @param decodeCharset
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String translate(String src, String encodeCharset, String decodeCharset)
            throws UnsupportedEncodingException
    {
        if ( StringUtils.isEmpty(src) )
        {
            return src;
        }

        return new String(src.getBytes(encodeCharset), decodeCharset);
    }

}
