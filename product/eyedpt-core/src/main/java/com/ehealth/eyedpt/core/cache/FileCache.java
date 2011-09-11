/*
 * Created on 2011-9-11
 */

package com.ehealth.eyedpt.core.cache;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * Provides file cache service.
 * 
 * @author emac
 */
@Service
public class FileCache
{

    private static final String DEFAULT_CACHE_DIR_NAME    = "cache";
    private static final int    DEFAULT_CACHE_FILE_LENGTH = 16;

    protected String            cacheDirName              = DEFAULT_CACHE_DIR_NAME;
    private int                 cacheFileLength           = DEFAULT_CACHE_FILE_LENGTH;
    private File                cacheBaseDir;
    private File                cacheDir;

    /**
     * Sets the base dir of cache. Can be set only once.
     * 
     * @param cacheBaseDir must be a directory
     * @throws IOException
     */
    public void setCacheBaseDir(File cacheBaseDir)
            throws IOException
    {
        if ( this.cacheBaseDir != null )
        {
            return;
        }

        Assert.notNull(cacheBaseDir);
        Assert.isTrue(cacheBaseDir.isDirectory());

        this.cacheBaseDir = cacheBaseDir;
        this.cacheDir = new File(this.cacheBaseDir, this.cacheDirName);

        FileUtils.forceDeleteOnExit(this.cacheDir);
    }

    /**
     * @param inputStream
     * @param fileExt
     * @return
     * @throws IOException
     */
    public File add(InputStream inputStream, String fileExt)
            throws IOException
    {
        Assert.notNull(inputStream);

        String cacheFileName = RandomStringUtils.randomAlphanumeric(this.cacheFileLength);
        cacheFileName += fileExt;
        File cacheFile = new File(this.cacheDir, cacheFileName);
        FileUtils.copyInputStreamToFile(inputStream, cacheFile);

        return cacheFile;
    }

}
