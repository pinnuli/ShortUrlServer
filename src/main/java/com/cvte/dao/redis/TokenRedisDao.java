package com.cvte.dao.redis;

import com.cvte.common.StaticConfig;
import com.cvte.po.User;
import com.cvte.util.JsonUtil;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

/**
 * @author linxiaoyi
 * @date 2019/4/29
 */
@Component
public class TokenRedisDao {

    /**
     * hash类型的key，存储用户信息，内部key为token，value为user
     */
    private final static String TOKEN_USER_INFO_KEY_PREFIX = "token_user_info_";

    /**
     * string类型的key的前缀，后缀为用户id，存储用户的token值
     */
    private final static String TOKEN_USER_TOKEN_KEY_PREFIX = "token_user_token_";

    private Jedis jedis = new Jedis("127.0.0.1", 6379, 500);

    public boolean existsToken(Integer userId) {
        return jedis.exists(generateKey(TOKEN_USER_TOKEN_KEY_PREFIX, userId.toString()));
    }

    public void setToken(Integer userId, String token){
        jedis.set(generateKey(TOKEN_USER_TOKEN_KEY_PREFIX, userId.toString()), token);
        expireToken(userId);
    }

    public String getToken(Integer userId) {
        return jedis.get(generateKey(TOKEN_USER_TOKEN_KEY_PREFIX, userId.toString()));
    }

    public void delToken(Integer userId) {
        jedis.del(generateKey(TOKEN_USER_TOKEN_KEY_PREFIX, userId.toString()));
    }

    public void expireToken(Integer userId) {
        jedis.expire(generateKey(TOKEN_USER_TOKEN_KEY_PREFIX, userId.toString()), StaticConfig.TOKEN_LIFECYCLE);
    }

    public boolean existsUser(String token) {
        return jedis.exists(generateKey(TOKEN_USER_INFO_KEY_PREFIX, token));
    }

    public void setUser(String token, User user) {
        jedis.set(generateKey(TOKEN_USER_INFO_KEY_PREFIX, token), JsonUtil.objectToJson(user));
    }

    public User getUser(String token) {
        String jsonUser = jedis.get(generateKey(TOKEN_USER_INFO_KEY_PREFIX, token));
        return (User)JsonUtil.jsonToObject(jsonUser, User.class);
    }

    public void delUser(String token) {
        jedis.del(generateKey(TOKEN_USER_INFO_KEY_PREFIX, token));
    }

    private String generateKey(String prefix, String postfix) {
        return prefix + postfix;
    }

}
