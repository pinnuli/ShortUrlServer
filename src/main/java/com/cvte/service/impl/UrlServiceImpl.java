package com.cvte.service.impl;

import com.cvte.po.Url;
import com.cvte.repository.UrlIndexRepository;
import com.cvte.repository.UrlRepository;
import com.cvte.service.UrlService;
import com.cvte.util.ShortUrlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * @author linxiaoyi
 * @date 2019/5/21
 */
@Service
public class UrlServiceImpl implements UrlService {

    @Autowired
    private UrlRepository urlRepository;

    @Autowired
    private UrlIndexRepository urlIndexRepository;

    private static char[][] shortUrlElement;

    static {
        shortUrlElement = ShortUrlUtil.initShortUrlData();
    }

    @Override
    public String getShortUrl(Integer userId, String longUrl){
        Url url = new Url(userId, getShortUrlString(), longUrl);
        urlRepository.addUrl(url);
        return url.getShortUrl();
    }

    @Override
    public String visitShortUrl(String shortUrl) {
        return urlRepository.getLongUrl(shortUrl);
    }

    /**
     * @return 短链字符串
     */
    private String getShortUrlString(){
        List<Integer> currentIndex = urlIndexRepository.getUrlIndex();
        int changeIndex = getChangeIndex(currentIndex);
        urlIndexRepository.updateUrlIndex(changeIndex);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < currentIndex.size(); i++) {
            if (i == changeIndex) {
                stringBuilder.append(shortUrlElement[currentIndex.get(i) + 1][i]);
            } else {
                stringBuilder.append(shortUrlElement[currentIndex.get(i)][i]);
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 在当前下标值随机自增某一下标的值
     * @param currentIndex 当前下标值
     * @return 下一组下标值
     */
    private int getChangeIndex(List<Integer> currentIndex) {
        Random random = new Random();
        int changeIndex = 0;
        do {
            changeIndex = random.nextInt(currentIndex.size());
            // 当下标达到最大时，重新设置需要修改的下标
        } while (currentIndex.get(changeIndex) == shortUrlElement.length - 1);
        return changeIndex;
    }
}