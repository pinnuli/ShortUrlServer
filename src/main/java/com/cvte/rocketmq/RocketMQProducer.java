package com.cvte.rocketmq;

import com.aliyun.openservices.ons.api.*;
import com.cvte.common.RocketMQConfig;
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
public class RocketMQProducer {
    @Autowired
    private RocketMQConfig rocketMQConfig;

    private static final Logger logger = LoggerFactory.getLogger(RocketMQProducer.class);

    /**
     * 1、发送普通消息
     *
     * @param message
     * @return
     */
    public void sendNormalMessage(Message message, String groupId) {

        Properties properties = rocketMQConfig.getProperties();
        properties.setProperty(PropertyKeyConst.GROUP_ID, groupId);
        Producer producer = ONSFactory.createProducer(properties);
        // 在发送消息前，必须调用 start 方法来启动 Producer，只需调用一次即可
        producer.start();
        try {
            SendResult sendResult = producer.send(message);
            // 同步发送消息，只要不抛异常就是成功
            if (sendResult != null) {
                logger.info("消息发送成功：messageID：" + sendResult.getMessageId());
            }
        } catch (Exception e) {
            // 消息发送失败，需要进行重试处理，可重新发送这条消息或持久化这条数据进行补偿处理
            logger.error("消息发送失败：" + e.getMessage());
        }
    }
}
