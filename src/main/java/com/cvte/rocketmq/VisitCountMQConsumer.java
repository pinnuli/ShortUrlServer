package com.cvte.rocketmq;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.openservices.ons.api.*;
import com.cvte.common.RocketMQConfig;
import com.cvte.common.StaticConfig;
import com.cvte.service.UrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * author@ pinnuli
 * date@ 2019/6/13
 */
@Component
public class VisitCountMQConsumer {

    @Autowired
    private RocketMQConfig rocketMQConfig;

    @Autowired
    private UrlService urlService;

    private static final Logger logger = LoggerFactory.getLogger(VisitCountMQConsumer.class);

    /**
     * 1、普通订阅
     *
     * @param
     */
    public void normalSubscribe() {

        Properties properties = rocketMQConfig.getProperties();

        properties.put(PropertyKeyConst.GROUP_ID, StaticConfig.ROCKETMQ_GROUP_ID);

        Consumer consumer = ONSFactory.createConsumer(properties);
        consumer.subscribe(StaticConfig.ROCKETMQ_TOPIC, "visit_count", new MessageListener() {
            @Override
            public Action consume(Message message, ConsumeContext context) {
                String shortUrl =  new String(message.getBody());
                logger.info("Receive shortUrl: " + shortUrl);
                urlService.increaseVisitCount(shortUrl);
                return Action.CommitMessage;
            }
        });
        consumer.start();
    }
}
