package com.cvte.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 * @author linxiaoyi
 * @date 2019/5/22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-mybatis.xml"})
public class UrlMapperTest {
    private static Logger log = LoggerFactory.getLogger(UrlMapperTest.class);

    @Autowired
    private UrlMapper urlMapper;

    private UrlIndexMapper urlIndexMapper;

    @Test
    public void testSelectReportDataByUserIdAndDate() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        log.info("size:{}", urlMapper.selectCreateReportByUserIdAndDate(3, sdf.parse("2019-06-14 00:00:00"), sdf.parse("2019-06-19 23:00:00")).size());
    }
}
