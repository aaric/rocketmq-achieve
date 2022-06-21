package com.sample.rocketmq.msg;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * MySource
 *
 * @author Aaric, created on 2022-06-16T11:28.
 * @version 0.4.0-SNAPSHOT
 */
public interface MySource {

    String OUTPUT = "my-output";

    @Output(MySource.OUTPUT)
    MessageChannel output();
}
