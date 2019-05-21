package com.cvte.util;

import com.cvte.common.StaticConfig;
import com.cvte.dao.UserMapper;
import com.cvte.dao.UserTokenMapper;
import com.cvte.dao.redis.TokenRedisDao;
import com.cvte.po.User;
import com.cvte.po.UserToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.util.Date;
import java.util.UUID;

/**
 * @author linxiaoyi
 * @date 2019/4/29
 */
@Component
public class TokenUtil {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserTokenMapper userTokenMapper;

    @Autowired
    private TokenRedisDao tokenRedisDao;

    private static final Logger log = LoggerFactory.getLogger(TokenUtil.class);

    @Transactional
    public String issueToken(Integer userId) {
        UserToken userToken = new UserToken(userId, getToken());
        try {
            if (tokenRedisDao.existsToken(userId)) {
                String oldToken = tokenRedisDao.getToken(userId);
                tokenRedisDao.delUser(oldToken);
            }
            User user = userMapper.getUserById(userId);
            tokenRedisDao.setToken(userId, userToken.getToken());
            tokenRedisDao.setUser(userToken.getToken(), user);
        } catch (JedisConnectionException e) {
            log.error("can not connect to redis!");
            userTokenMapper.insertOrUpdate(userToken);
        }
        return userToken.getToken();
    }

    public boolean checkToken(String token) {
        try {
            if (tokenRedisDao.existsUser(token)) {
                return true;
            }
            UserToken userToken = userTokenMapper.selectByToken(token);
            if (userToken != null && userToken.getExpireTime().getTime() > System.currentTimeMillis()) {
                tokenRedisDao.setToken(userToken.getUserId(), userToken.getToken());
                User user = userMapper.getUserById(userToken.getUserId());
                tokenRedisDao.setUser(userToken.getToken(), user);
                return true;
            }
        } catch (JedisConnectionException e) {
            log.error("can not connect to redis!");
            UserToken userToken = userTokenMapper.selectByToken(token);
            return userToken != null && userToken.getExpireTime().getTime() > System.currentTimeMillis();
        }
        return false;
    }

    @Transactional
    public User updateToken(String token) {
        User user;
        try {
            user = tokenRedisDao.getUser(token);
            tokenRedisDao.expireToken(user.getUserId());
            return user;
        } catch (JedisConnectionException e) {
            log.error("can not connect to redis!");
            UserToken userToken = userTokenMapper.selectByToken(token);
            user = userMapper.getUserById(userToken.getUserId());
            userTokenMapper.updateExpireTimeByUserId(userToken.getUserId(), DateTimeUtil.getDateTimeAfterSeconds(StaticConfig.TOKEN_LIFECYCLE));
            return user;
        }
    }

    @Transactional
    public void deleteToken(Integer userId) {
        try {
            String token = tokenRedisDao.getToken(userId);
            tokenRedisDao.delToken(userId);
            tokenRedisDao.delUser(token);
            userTokenMapper.updateExpireTimeByUserId(userId, new Date());
        } catch (JedisConnectionException e) {
            log.error("can not connect to redis!");
            userTokenMapper.updateExpireTimeByUserId(userId, new Date());
        }
    }

    private String getToken() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
