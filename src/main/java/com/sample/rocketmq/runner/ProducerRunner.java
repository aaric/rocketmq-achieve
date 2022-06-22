package com.sample.rocketmq.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;

/**
 * CustomRunner
 *
 * @author Aaric, created on 2022-06-20T15:24.
 * @version 0.4.0-SNAPSHOT
 */
//@Component
public class ProducerRunner implements CommandLineRunner {

    @Autowired
    private Source source;

    @Override
    public void run(String... args) throws Exception {
        // ?? real : toString is override with null
        System.err.println("------------------>" + source);
        System.err.println("------------------>" + source.output());
        System.err.println("------------------>" + source);

        for (int i = 0; i < 5; i++) {
            source.output().send(MessageBuilder.withPayload("msg-" + i).build());
        }
    }
}
