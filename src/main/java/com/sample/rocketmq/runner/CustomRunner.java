package com.sample.rocketmq.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.stereotype.Component;

/**
 * CustomRunner
 *
 * @author Aaric, created on 2022-06-20T15:24.
 * @version 0.4.0-SNAPSHOT
 */
@Component
public class CustomRunner implements CommandLineRunner {

    @Autowired
    private Source source;

    @Override
    public void run(String... args) throws Exception {
        System.err.println("------------------>" + source);
    }
}
