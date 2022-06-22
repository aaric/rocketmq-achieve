package com.sample.rocketmq.msg;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * MySink
 *
 * @author Aaric, created on 2022-06-20T17:35.
 * @version 0.4.0-SNAPSHOT
 */
public interface MySink {

    String INPUT = "my-input";

    @Input(MySink.INPUT)
    SubscribableChannel input();
}
