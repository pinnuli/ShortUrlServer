package com.cvte.service.impl;

import com.cvte.common.ResponseCode;
import com.cvte.common.StaticConfig;
import com.cvte.dao.UrlMapper;
import com.cvte.dao.redis.UrlRedisDao;
import com.cvte.exception.CommonException;
import com.cvte.po.Url;
import com.cvte.repository.UrlRepository;
import com.cvte.service.ShortUrlService;
import com.cvte.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import redis.clients.jedis.exceptions.JedisConnectionException;

/**
 * @author linxiaoyi
 * @date 2019/5/21
 */
@Service
public class ShortUrlServiceImpl implements ShortUrlService {

    @Autowired
    private UrlRepository urlRepository;

    @Override
    public String generateShortUrl(Integer userId, String longUrl) {
        Url url = new Url(userId, longUrl);
        generateShortUrlAndSaveUrl(url);
        return url.getShortUrl();
    }

    @Override
    public String visitShortUrl(String shortUrl) {
        return urlRepository.getLongUrl(shortUrl);
    }

    private void generateShortUrlAndSaveUrl(Url url) {
        for (int tryCount = 4; tryCount >= 0; tryCount --){
            try {
                System.out.println("try" + tryCount);
                url.setShortUrl(StringUtil.getRandomString(StaticConfig.SHORT_URL_LENGTH));
                urlRepository.addUrl(url);
                break;
            } catch (DataAccessException e) {
                if (tryCount == 0) {
                    throw new CommonException(ResponseCode.UNKNOWN_EXCEPTION_ERROR);
                }
            }
        }
    }

}