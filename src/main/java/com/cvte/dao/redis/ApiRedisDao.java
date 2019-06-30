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

    private final static String DETAIL_API_INFO_HASH = "detail_api_info";

    private final static String OUTLINE_API_INFO_HASH = "outline_api_info";

    private Jedis jedis = new Jedis("106.14.224.12", 6379, 20000);

    {
        jedis.auth("123456");
    }

    public void setDetailApiList(List<Api> apiInfoList) {
        for (Api api : apiInfoList) {
            jedis.hset(DETAIL_API_INFO_HASH, api.getApiId().toString(), JsonUtil.objectToJson(api));
        }
        jedis.expire(DETAIL_API_INFO_HASH, StaticConfig.API_INFO_CHCHE_EXPIRE);
        jedis.close();
    }

    public List<Api> getDetailApiList() {
        List<Api> result = new ArrayList<>();
        for (String apiJsonString : jedis.hvals(DETAIL_API_INFO_HASH)) {
            result.add((Api)JsonUtil.jsonToObject(apiJsonString, Api.class));
        }
        jedis.close();
        return result;
    }

    public void deleteDetailApiList() {
        jedis.del(DETAIL_API_INFO_HASH);
        jedis.close();
    }

    public void setOutlineApiList(List<Api> apiInfoList) {
        for (Api api : apiInfoList) {
            jedis.hset(OUTLINE_API_INFO_HASH, api.getApiId().toString(), JsonUtil.objectToJson(api));
        }
        jedis.expire(OUTLINE_API_INFO_HASH, StaticConfig.API_INFO_CHCHE_EXPIRE);
        jedis.close();
    }

    public List<Api> getOutlineApiList() {
        List<Api> result = new ArrayList<>();
        for (String apiJsonString : jedis.smembers(OUTLINE_API_INFO_HASH)) {
            result.add((Api)JsonUtil.jsonToObject(apiJsonString, Api.class));
        }
        jedis.close();
        return result;
    }

    public void deleteOutlineApiList() {
        jedis.del(OUTLINE_API_INFO_HASH);
        jedis.close();
    }

}
