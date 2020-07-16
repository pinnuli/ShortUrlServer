package com.cvte.common;

import com.aliyun.openservices.ons.api.PropertyKeyConst;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * author@ pinnuli
 * date@ 2019/6/13
 */
@Configuration
public class RocketMQConfig {
    public Properties getProperties(){
        Properties properties=new Properties();
        properties.setProperty("AccessKey","");
        properties.setProperty("SecretKey","");
        //顺序消息消费超时时间
        properties.setProperty(PropertyKeyConst.SendMsgTimeoutMillis, "3000");
        // 顺序消息消费失败进行重试前的等待时间，单位(毫秒)
        properties.put(PropertyKeyConst.SuspendTimeMillis, "100");
        // 消息消费失败时的最大重试次数
        properties.put(PropertyKeyConst.MaxReconsumeTimes, "20");
        // 接入点
        properties.put(PropertyKeyConst.NAMESRV_ADDR, "http://MQ_INST_1195702369481992_Baxw3Mrk.mq-internet-access.mq-internet.aliyuncs.com:80");
        return  properties;
    }
}
