package com.sample.rocketmq.client;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * ProducerTests
 *
 * @author Aaric, created on 2022-06-14T17:31.
 * @version 0.2.0-SNAPSHOT
 */
@Disabled
@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ProducerTests {

    @Value("${rocketmq.name-server}")
    private String namesrvAddr;

    @Value("${rocketmq.producer.group}")
    private String groupName;

    @Disabled
    @RepeatedTest(10)
    public void testSend() {
        Assertions.assertDoesNotThrow(() -> {
            DefaultMQProducer producer = new DefaultMQProducer(groupName);
            producer.setNamesrvAddr(namesrvAddr);
            producer.start();
            Message msg = new Message("TopicTest", "TagA", "Hello RocketMQ".getBytes());
            SendResult sendResult = producer.send(msg, 10000);
            log.info("{}", sendResult);
            producer.shutdown();
        });
    }
}
