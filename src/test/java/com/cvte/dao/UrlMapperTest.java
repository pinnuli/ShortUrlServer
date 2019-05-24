package com.cvte.dao;

import com.cvte.po.Url;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

    @Test
    public void testInsert() {
        Url url = new Url(1, "https://www.baidu.com/s?\n" +
                "wd=%E7%9F%AD%E9%93%BE%E6%8E%A5&rsvspt=1&rsviqid=0xb3cd9f3f000072ce&issp=1&f=3&rsvbp=1&rsvidx=2&ie=utf-\n" +
                "8&rqlang=cn&tn=baiduhomepg&rsventer=1&oq=%25E7%259F%25AD%25E9%2593%25BE&rsvt=ff9cPd%2B8k7S6nG0RKSj8qsh%2FqrnL9um5osA");
        url.setShortUrl("Vft7eiS");
        try {
            urlMapper.insert(url);
        } catch (DataAccessException e) {
            System.out.println(e.getMessage());
        }
    }
}
