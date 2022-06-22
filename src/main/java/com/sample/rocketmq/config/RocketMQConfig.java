package com.sample.rocketmq.config;

import com.sample.rocketmq.msg.LogMsg;
import com.sample.rocketmq.msg.MySink;
import com.sample.rocketmq.msg.NotifyMsg;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.Message;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

/**
 * RocketMQ 配置
 *
 * @author Aaric, created on 2022-06-16T11:37.
 * @version 0.4.0-SNAPSHOT
 */
@Slf4j
@Configuration
public class RocketMQConfig {

    public static final String DEFAULT_HEADER_NAME = "X-Msg-Type";

    @StreamListener(Sink.INPUT)
    public void receiveSink(String msg) {
        log.info("receiveSink --> msg={}", msg);
    }

    @StreamListener(Sink.INPUT)
    public void receiveSink(@Header(DEFAULT_HEADER_NAME) String type, Message msg) {
        log.info("receiveSink --> type={}, msg={}", type, msg);
    }

    @StreamListener(MySink.INPUT)
    public void receiveMySink(String msg) {
        log.info("receiveMySink --> msg={}", msg);
    }

    @StreamListener(value = MySink.INPUT, condition = "headers['" + DEFAULT_HEADER_NAME + "']=='" + LogMsg.DEFAULT_HEADER_VALUE + "'")
    public void receiveMySinkForLog(@Payload LogMsg msg) {
        log.info("receiveMySinkForLog --> msg={}", msg);
    }

    @StreamListener(value = MySink.INPUT, condition = "headers['" + DEFAULT_HEADER_NAME + "']=='" + NotifyMsg.DEFAULT_HEADER_VALUE + "'")
    public void receiveMySinkForNotify(@Payload NotifyMsg msg) {
        log.info("receiveMySinkForNotify --> msg={}", msg);
    }
}
