package com.cvte.rocketmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * author@ pinnuli
 * date@ 2019/6/17
 */
@Component
public class VisitCountMQConsumerListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private VisitCountMQConsumer visitCountMQConsumer;

    private static final Logger logger = LoggerFactory.getLogger(VisitCountMQConsumerListener.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(event.getApplicationContext().getParent() == null){
            logger.info("VisitCountMQConsumer消费者启动");
            visitCountMQConsumer.normalSubscribe();
        }
    }
}
