package com.cvte.service.impl;

import com.cvte.po.Url;
import com.cvte.po.UrlReport;
import com.cvte.repository.UrlIndexRepository;
import com.cvte.repository.UrlRepository;
import com.cvte.rocketmq.RocketMQProducer;
import com.cvte.service.UrlService;
import com.cvte.util.ShortUrlUtil;
import com.cvte.vo.CreateReportVo;
import com.cvte.vo.VisitReportVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    private RocketMQProducer rocketMQProducer;

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
        String longUrl = urlRepository.getLongUrl(shortUrl);
        /*if (longUrl != null) {
            // 发送urlId到消息队列以更新访问数量
            Message message=new Message(StaticConfig.ROCKETMQ_TOPIC,"visit_count", shortUrl.getBytes());
            rocketMQProducer.sendNormalMessage(message, StaticConfig.ROCKETMQ_GROUP_ID);
        }*/
        urlRepository.increaseVisitCount(shortUrl);
        return longUrl;
    }

    @Override
    public void increaseVisitCount(String shortUrl) {
        urlRepository.increaseVisitCount(shortUrl);
    }

    @Override
    public List<CreateReportVo> getCreateReportData(Integer userId, Date startDate, Date endDate) {
        List<UrlReport> reportList = urlRepository.getCreateReportData(userId, startDate, endDate);
        List<CreateReportVo> createReportVoList = new ArrayList<>();
        for (UrlReport urlReport : reportList) {
            createReportVoList.add(new CreateReportVo(urlReport));
        }
        return createReportVoList;
    }

    @Override
    public List<VisitReportVo> getVisitReportData(Integer userId, Date startDate, Date endDate) {
        List<UrlReport> reportList = urlRepository.getVisitReportData(userId, startDate, endDate);
        List<VisitReportVo> visitReportVoList = new ArrayList<>();
        for (UrlReport urlReport : reportList) {
            visitReportVoList.add(new VisitReportVo(urlReport));
        }
        return visitReportVoList;
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