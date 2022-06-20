package com.sample.rocketmq.stream;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * MyMsgTests
 *
 * @author Aaric, created on 2022-06-16T11:33.
 * @version 0.4.0-SNAPSHOT
 */
@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class MyMsgTests {

    @Autowired
    private Source source;

    @Disabled
    @Test
    public void testDirectChannel() {
        Assertions.assertDoesNotThrow(() -> {
            SubscribableChannel channel = new DirectChannel();

            channel.subscribe(msg -> log.info("receive1: {}", msg.getPayload()));
            channel.subscribe(msg -> log.info("receive2: {}", msg.getPayload()));

            channel.send(MessageBuilder.withPayload("msg1").build());
            channel.send(MessageBuilder.withPayload("msg2").build());
        });
    }

    @Disabled
    @Test
    public void testPublishSubscribeChannel() {
        Assertions.assertDoesNotThrow(() -> {
            SubscribableChannel channel = new PublishSubscribeChannel();

            channel.subscribe(msg -> log.info("receive1: {}", msg.getPayload()));
            channel.subscribe(msg -> log.info("receive2: {}", msg.getPayload()));

            channel.send(MessageBuilder.withPayload("msg1").build());
            channel.send(MessageBuilder.withPayload("msg2").build());
        });
    }

    @Disabled
    @Test
    public void testSource() {
        Assertions.assertDoesNotThrow(() -> {
            log.info("{}", source.output().send(MessageBuilder.withPayload("hello source").build()));
        });
    }
}
