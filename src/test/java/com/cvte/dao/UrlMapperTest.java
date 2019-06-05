package com.cvte.dao;

import com.cvte.po.Url;
import com.cvte.util.ShortUrlUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;


/**
 * @author linxiaoyi
 * @date 2019/5/22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class UrlMapperTest {
    private static Logger log = LoggerFactory.getLogger(UrlMapperTest.class);

    @Autowired
    private UrlMapper urlMapper;

    private UrlIndexMapper urlIndexMapper;
}
