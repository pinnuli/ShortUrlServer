package com.cvte.service.impl;

import com.cvte.common.StaticConfig;
import com.cvte.dao.UserMapper;
import com.cvte.dao.UserTokenMapper;
import com.cvte.dao.redis.TokenRedisDao;
import com.cvte.po.User;
import com.cvte.po.UserToken;
import com.cvte.repository.UserTokenRepository;
import com.cvte.service.TokenService;
import com.cvte.util.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.util.Date;
import java.util.UUID;

/**
 * @author linxiaoyi
 * @date 2019/5/22
 */
@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private UserTokenRepository userTokenRepository;

    private static final Logger log = LoggerFactory.getLogger(TokenServiceImpl.class);

    @Override
    @Transactional
    public String issueToken(Integer userId) {
        UserToken userToken = new UserToken(userId, generateToken());
        userTokenRepository.addToken(userToken);
        return userToken.getToken();
    }

    @Override
    public boolean checkToken(String token) {
        return userTokenRepository.getToken(token);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User updateToken(String token) {
        User user = userTokenRepository.updateToken(token);
        return user;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteToken(Integer userId) {
        userTokenRepository.deleteToken(userId);
    }

    private String generateToken() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
