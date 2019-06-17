package com.cvte.dao.redis;

import com.cvte.common.StaticConfig;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

/**
 * @author linxiaoyi
 * @date 2019/5/22
 */
@Component
public class UrlRedisDao {

    /**
     * url键值前缀
     */
    private static final String URL_KEY_PREFIX = "url_";

    private Jedis jedis = new Jedis("106.14.224.12", 6379, 2000);

    {
        jedis.auth("123456");
    }

    public String getUrl(String shortUrl) {
        return jedis.get(generateKey(URL_KEY_PREFIX, shortUrl));
    }

    public void setUrl(String shortUrl, String longUrl) {
        jedis.set(generateKey(URL_KEY_PREFIX, shortUrl), longUrl);
        jedis.expire(generateKey(URL_KEY_PREFIX, shortUrl), StaticConfig.URL_CACHE_EXPIRE);
    }

    private String generateKey(String prefix, String postfix) {
        return prefix + postfix;
    }
}
