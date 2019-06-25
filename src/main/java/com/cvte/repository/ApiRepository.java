package com.cvte.repository;

import com.cvte.dao.ApiMapper;
import com.cvte.dao.redis.ApiRedisDao;
import com.cvte.po.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pinnuli
 * @date 2019/6/25
 */
@Component
public class ApiRepository {

    @Autowired
    private ApiMapper apiMapper;

    @Autowired
    private ApiRedisDao apiRedisDao;

    private final static Logger log = LoggerFactory.getLogger(ApiRepository.class);

    public List<Api> getAllApi() {
        List<Api> apiList;
        try {
            apiList = apiRedisDao.getApiList();
            if (apiList.size() == 0) {
                apiList = apiMapper.selectApiList();
                apiRedisDao.setApiList(apiList);
            }
        } catch (JedisConnectionException e) {
            e.printStackTrace();
            log.error("can not connect to redis!");
            apiList = apiMapper.selectApiList();
        }
        return apiList;
    }
}
