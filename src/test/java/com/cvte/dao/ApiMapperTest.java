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
public class ApiMapperTest {
    private static Logger log = LoggerFactory.getLogger(ApiMapperTest.class);

    @Autowired
    private ApiMapper apiMapper;

    @Test
    public void testSelectApiList() throws ParseException {
        log.info("api->size:{},", apiMapper.selectApiList().size());
        log.info("apiRequestExample->size:{},", apiMapper.selectApiList().get(0).getRequestExampleList().size());
        log.info("apiRequestParameter->size:{},", apiMapper.selectApiList().get(0).getRequestParameterList().size());
        log.info("apiResponseParameter->size:{},", apiMapper.selectApiList().get(0).getResponseParameterList().size());
    }
}
