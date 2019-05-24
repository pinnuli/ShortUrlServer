package com.cvte.service;

/**
 * @author linxiaoyi
 * @date 2019/5/21
 */
public interface ShortUrlService {

    /**
     * @param userId 用户id
     * @param longUrl 长链接
     * @return 生成的短链接
     */
    String generateShortUrl(Integer userId, String longUrl);

    /**
     * @param shortUrl 短链接
     * @return 对应长链接
     */
    String visitShortUrl(String shortUrl);
}
