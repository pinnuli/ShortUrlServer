package com.cvte.po;

import redis.clients.jedis.JedisPubSub;

import java.io.Serializable;

/**
 * @author linxiaoyi
 * @date 2019/5/21
 */
public class Url implements Serializable {

    private Integer userId;

    private String shortUrl;

    private String longUrl;

    private Integer visitCount;

    public Url() {}

    public Url(Integer userId, String longUrl) {
        this.userId = userId;
        this.longUrl = longUrl;
    }

    public Integer getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Integer visitCount) {
        this.visitCount = visitCount;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
