package com.cvte.dao.redis;

import com.cvte.common.StaticConfig;
import com.cvte.po.Api;
import com.cvte.util.JsonUtil;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pinnuli
 * @date 2019/6/25
 */
@Component
public class ApiRedisDao {

    private final static String API_INFO_SET = "api_info";

    private Jedis jedis = new Jedis("106.14.224.12", 6379, 20000);

    {
        jedis.auth("123456");
    }

    public void setApiList(List<Api> apiInfoList) {
        for (Api api : apiInfoList) {
            jedis.sadd(API_INFO_SET, JsonUtil.objectToJson(api));
        }
        jedis.expire(API_INFO_SET, StaticConfig.API_INFO_CHCHE_EXPIRE);
        jedis.close();
    }

    public List<Api> getApiList() {
        List<Api> result = new ArrayList<>();
        for (String apiJsonString : jedis.smembers(API_INFO_SET)) {
            result.add((Api)JsonUtil.jsonToObject(apiJsonString, Api.class));
        }
        return result;
    }

}
