package com.cvte.service.impl;

import com.cvte.service.ShortUrlService;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * ShortUrlServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>五月 22, 2019</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class ShortUrlServiceImplTest {

    private final static Logger log = LoggerFactory.getLogger(ShortUrlServiceImplTest.class);

    @Autowired
    private ShortUrlService shortUrlService;
    /**
     * Method: getLongUrl(String shortUrl)
     */
    @Test
    public void testGetLongUrl() throws Exception {
        /*System.out.println(shortUrlService.visitShortUrl("Vft7eiS"));*/
        log.info("你好");
    }

} 
