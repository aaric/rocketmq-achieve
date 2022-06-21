package com.sample.rocketmq.config;

import com.sample.rocketmq.msg.MySink;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Configuration;

/**
 * RocketMQ 配置
 *
 * @author Aaric, created on 2022-06-16T11:37.
 * @version 0.4.0-SNAPSHOT
 */
@Slf4j
@Configuration
public class RocketMQConfig {

    @StreamListener(Sink.INPUT)
    public void receiveSink(String msg) {
        log.info("receiveSink: {}", msg);
    }

    @StreamListener(MySink.INPUT)
    public void receiveMySink(String msg) {
        log.info("receiveMySink: {}", msg);
    }
}
