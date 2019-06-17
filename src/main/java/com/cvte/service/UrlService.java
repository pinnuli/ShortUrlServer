package com.cvte.service;

import java.io.IOException;

/**
 * @author linxiaoyi
 * @date 2019/5/21
 */
public interface UrlService {

    /**
     * @param userId 用户id
     * @param longUrl 长链接
     * @return 生成的短链接
     */
    String getShortUrl(Integer userId, String longUrl) throws IOException;

    /**
     * @param shortUrl 短链接
     * @return 对应长链接
     */
    String visitShortUrl(String shortUrl);

    /**
     * 增加短链访问次数
     * @param shortUrl 短链
     */
    void increaseVisitCount(String shortUrl);
}
