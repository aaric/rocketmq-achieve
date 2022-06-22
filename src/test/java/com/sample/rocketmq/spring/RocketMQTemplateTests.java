package com.sample.rocketmq.spring;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * RocketMQTemplateTests
 *
 * @author Aaric, created on 2022-06-15T10:35.
 * @version 0.3.0-SNAPSHOT
 */
@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class RocketMQTemplateTests {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Disabled
    @Test
    public void testSyncSend() {
        Assertions.assertDoesNotThrow(() -> {
            SendResult sendResult = rocketMQTemplate.syncSend("TopicTest:TagA", " the sync msg", 10000);
            log.info("{}", sendResult);
        });
    }

    @Disabled
    @Test
    public void testAsyncSend() {
        Assertions.assertDoesNotThrow(() -> {
            rocketMQTemplate.asyncSend("TopicTest:TagA", " the async msg", new SendCallback() {

                @Override
                public void onSuccess(SendResult sendResult) {
                    log.info("{}", sendResult);
                }

                @Override
                public void onException(Throwable e) {
                    log.error("asyncSend exception", e);
                }
            });

            TimeUnit.SECONDS.sleep(15);
        });
    }

    @Disabled
    @Test
    public void testSendOneWay() {
        Assertions.assertDoesNotThrow(() -> {
            rocketMQTemplate.sendOneWay("TopicTest:TagA", " the one way msg");
        });
    }

    @Disabled
    @Test
    public void testSendOneWayOrderly() {
        Assertions.assertDoesNotThrow(() -> {
            String hashKey = UUID.randomUUID().toString();
            rocketMQTemplate.sendOneWayOrderly("TopicTest:TagA", " the one way orderly msg", hashKey);
        });
    }

    @Disabled
    @Test
    public void testSendMessageInTransaction() {
        Assertions.assertDoesNotThrow(() -> {
            String txId = UUID.randomUUID().toString();
            String msg = "the transaction msg";
            TransactionSendResult sendResult = rocketMQTemplate.sendMessageInTransaction("tx-aaa",
                    "TopicTest:TagA",
                    MessageBuilder.withPayload(msg).setHeader("txId", txId).build(),
                    msg);
            log.info("{}", sendResult);
        });
    }
}
