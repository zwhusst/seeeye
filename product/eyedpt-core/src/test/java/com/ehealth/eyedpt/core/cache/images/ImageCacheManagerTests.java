/*
 * Created on 2011-9-11
 */

package com.ehealth.eyedpt.core.cache.images;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

/**
 * @author emac
 */
@ContextConfiguration("classpath:WEB-INF/spring/context-core.xml")
public class ImageCacheManagerTests extends AbstractTransactionalJUnit4SpringContextTests
{

    private static final String BASE_DIR_NAME      = "/temp";
    private static final String TEST_KEY           = "foo";
    private static final String TEST_IMAGE_CONTENT = "I'm a fake image!";

    @Autowired
    private ImageCache          imageCache;

    @Autowired
    private ImageCacheManager   imageCacheManager;

    @Before
    public void before()
    {
        File baseDir = new File(BASE_DIR_NAME);
        baseDir.mkdirs();
        this.imageCache.setCacheBaseDir(baseDir);
    }

    @Test
    public void testPut()
            throws IOException
    {
        File cache = this.imageCacheManager.get(TEST_KEY);
        Assert.assertNull(cache);

        InputStream is = IOUtils.toInputStream(TEST_IMAGE_CONTENT);
        this.imageCacheManager.put(TEST_KEY, is);

        cache = this.imageCacheManager.get(TEST_KEY);
        Assert.assertNotNull(cache);

        String content = FileUtils.readFileToString(cache);
        Assert.assertEquals(TEST_IMAGE_CONTENT, content);
    }

}
