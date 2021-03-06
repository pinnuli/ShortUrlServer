package com.cvte.repository;

import com.cvte.dao.UrlMapper;
import com.cvte.dao.redis.UrlRedisDao;
import com.cvte.po.Url;
import com.cvte.po.UrlDateReport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.util.Date;
import java.util.List;

/**
 * @author linxiaoyi
 * @date 2019/5/23
 */
@Component
public class UrlRepository {

    @Autowired
    private UrlRedisDao urlRedisDao;

    @Autowired
    private UrlMapper urlMapper;

    private final static Logger log = LoggerFactory.getLogger(UrlRepository.class);

    public String getLongUrl(String shortUrl) {
        String longUrl = null;
        try {
            longUrl = urlRedisDao.getUrl(shortUrl);
            if (longUrl == null) {
                longUrl = urlMapper.selectLongUrlByShortUrl(shortUrl);
                if (longUrl != null) {
                    urlRedisDao.setUrl(shortUrl, longUrl);
                }
            }
        } catch (JedisConnectionException e) {
            longUrl = urlMapper.selectLongUrlByShortUrl(shortUrl);
        }
        return longUrl;
    }

    public void addUrl(Url url) {
        try {
            urlMapper.insert(url);
            urlRedisDao.setUrl(url.getShortUrl(), url.getLongUrl());
        } catch (JedisConnectionException e) {
            log.error("can not connect to redis!");
        }
    }

    public void increaseVisitCount(String shortUrl) {
        urlMapper.increaseVisitCount(shortUrl);
    }
    
    public List<UrlDateReport> getCreateReportData(Integer userId, Date startDate, Date endDate) {
        return urlMapper.selectCreateReportByUserIdAndDate(userId, startDate, endDate);
    }

    public List<UrlDateReport> getVisitReportData(Integer userId, Date startDate, Date endDate) {
        return urlMapper.selectVisitReportByUserIdAndDate(userId, startDate, endDate);
    }
}
