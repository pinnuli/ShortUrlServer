package com.cvte.dao;

import com.cvte.po.Api;
import com.cvte.po.ApiRequestExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.util.List;


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
        List<Api> list = apiMapper.selectDetailApiList();
        log.info("api->size:{},",list .size());
        log.info("apiRequestExample->size:{},", apiMapper.selectDetailApiList().get(0).getRequestExampleList().size());
        log.info("apiRequestParameter->size:{},", apiMapper.selectDetailApiList().get(0).getRequestParameterList().size());
        log.info("apiResponseParameter->size:{},", apiMapper.selectDetailApiList().get(0).getResponseParameterList().size());
    }

    @Test
    public void testInsertApi() {
        List<Api> apiList = apiMapper.selectOutlineApiList();
        Api api = apiList.get(0);
        api.setResponseExample("test1");
        apiMapper.insertApi(api);
        log.info("apiId:{}", api.getApiId());
    }

    @Test
    public void testUpdateApi() {
        List<Api> apiList = apiMapper.selectOutlineApiList();
        Api api = apiList.get(0);
        api.setResponseExample("test1");
        apiMapper.updateApi(api);
        log.info("apiId:{}", api.getApiId());
    }

    @Test
    public void testInsertOrUpdateRequestExample() {
        Api api = apiMapper.selectDetailApi(1);
        ApiRequestExample apiRequestExample = new ApiRequestExample();
        apiRequestExample.setLanguage("test");
        apiRequestExample.setContent("test");
        apiRequestExample.setApiId(1);
        api.getRequestExampleList().get(5).setContent("testKotlin");
        api.getRequestExampleList().add(apiRequestExample);
        apiMapper.insertOrUpdateRequestExample(api.getRequestExampleList());
        log.info("size:{}", api.getRequestExampleList().size());
        log.info("apiId:{}", api.getApiId());
    }

}
