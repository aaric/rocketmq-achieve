package com.sample.rocketmq.stream;

import com.sample.rocketmq.config.RocketMQConfig;
import com.sample.rocketmq.msg.LogMsg;
import com.sample.rocketmq.msg.MySource;
import com.sample.rocketmq.msg.NotifyMsg;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.messaging.Message;
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

    @Autowired
    private MySource mySource;

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
    public void testSourceSend() {
        Assertions.assertDoesNotThrow(() -> {
            log.info("{}", source.output().send(MessageBuilder.withPayload("hello source").build()));
        });
    }

    @Disabled
    @Test
    public void testMySourceSend() {
        Assertions.assertDoesNotThrow(() -> {
            log.info("{}", mySource.output().send(MessageBuilder.withPayload("hello my source").build()));
        });
    }

    @Disabled
    @Test
    public void testMySourceSendLogMsg() {
        Assertions.assertDoesNotThrow(() -> {
            LogMsg log = new LogMsg()
                    .setId(RandomUtils.nextInt())
                    .setLogType(1)
                    .setContent("hello log");
            Message<LogMsg> msg = MessageBuilder.withPayload(log)
                    .setHeader(RocketMQConfig.DEFAULT_HEADER_NAME, LogMsg.DEFAULT_HEADER_VALUE).build();
            mySource.output().send(msg);
        });
    }

    @Disabled
    @Test
    public void testMySourceSendNotifyMsg() {
        Assertions.assertDoesNotThrow(() -> {
            NotifyMsg notify = new NotifyMsg()
                    .setFrom("11")
                    .setTo(new String[]{"22", "333"})
                    .setContent("hello notify");
            Message<NotifyMsg> msg = MessageBuilder.withPayload(notify)
                    .setHeader(RocketMQConfig.DEFAULT_HEADER_NAME, NotifyMsg.DEFAULT_HEADER_VALUE).build();
            mySource.output().send(msg);
        });
    }
}
