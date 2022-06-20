package com.sample.rocketmq.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQListener;

/**
 * RocketMQStringListener
 *
 * @author Aaric, created on 2022-06-15T11:00.
 * @version 0.3.0-SNAPSHOT
 */
@Slf4j
//@Component
//@RocketMQMessageListener(consumerGroup = "aaa", topic = "TopicTest")
public class RocketMQStringListener implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        log.info("{}", message);
    }
}
