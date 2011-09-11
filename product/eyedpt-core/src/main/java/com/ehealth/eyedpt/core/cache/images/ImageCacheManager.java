/*
 * Created on 2011-9-11
 */

package com.ehealth.eyedpt.core.cache.images;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service to manage image caches.
 * 
 * @author emac
 */
@Service
public class ImageCacheManager
{

    @Autowired
    private ImageCache        imageCache;

    private Map<String, File> imageMap = Collections.synchronizedMap(new HashMap<String, File>());

    /**
     * Generates a cache file from the given input stream and binds it to the given key.
     * 
     * @param key
     * @param inputStream
     * @throws IOException
     */
    public void put(String key, InputStream inputStream)
            throws IOException
    {
        // keep a reference to old cache
        File oldCacheFile = get(key);

        // TODO#EMAC.P2 uniform image size, format
        File newCacheFile = this.imageCache.add(inputStream, ".jpg");
        this.imageMap.put(key, newCacheFile);

        // clean old cache
        if ( oldCacheFile != null && oldCacheFile.exists() )
        {
            oldCacheFile.delete();
        }
    }

    /**
     * Gets the cache image file bound to the given key.
     * 
     * @param key
     * @return
     */
    public File get(String key)
    {
        return this.imageMap.get(key);
    }

}
