/*
 * Created on 2011-9-11
 */

package com.ehealth.eyedpt.core.cache.images;

import org.springframework.stereotype.Service;

import com.ehealth.eyedpt.core.cache.FileCache;

/**
 * Provides image cache service.
 * 
 * @author emac
 */
@Service
public class ImageCache extends FileCache
{

    /**
     * 
     */
    public ImageCache()
    {
        this.cacheDirName += "/images";
    }

}
