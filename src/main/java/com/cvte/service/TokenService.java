package com.cvte.service;

import com.cvte.common.StaticConfig;
import com.cvte.po.User;
import com.cvte.po.UserToken;
import com.cvte.util.DateTimeUtil;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.util.Date;

/**
 * @author linxiaoyi
 * @date 2019/5/22
 */
public interface TokenService {
    String issueToken(Integer userId);

    boolean checkToken(String token);

    User updateToken(String token);

    void deleteToken(Integer userId);

}
