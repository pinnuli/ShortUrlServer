package com.cvte.controller;

import com.aliyun.openservices.ons.api.Message;
import com.cvte.rocketmq.VisitCountMQConsumer;
import com.cvte.rocketmq.RocketMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author@ pinnuli
 * date@ 2019/6/13
 */
@RestController
public class RocketMQController {
    @Autowired
    private RocketMQProducer rocketMQProducer;

    @Autowired
    private VisitCountMQConsumer visitCountMQConsumer;

    //发送信息
    @RequestMapping("/send")
    public String send(){
        String msg = "hello";
        // test 是创建的topic是名称， tag 是消息的二级分类，可以填空
        Message message=new Message("TOPIC_TEST","tag",msg.getBytes());
        // GID-test 是 发送信息组ID
        rocketMQProducer.sendNormalMessage(message,"GID_TEST");
        return "ok";
    }


    //接收信息
    @RequestMapping("/receive")
    public String receive(){
        visitCountMQConsumer.normalSubscribe();
        return "ok";
    }
}
