package com.sample.rocketmq;

import com.sample.rocketmq.msg.MySink;
import com.sample.rocketmq.msg.MySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;

/**
 * 学习应用
 *
 * @author Aaric, created on 2022-06-14T14:50.
 * @version 0.1.0-SNAPSHOT
 */
@EnableBinding({Source.class, Sink.class, MySource.class, MySink.class})
@SpringBootApplication
public class MyApp {

    /**
     * main
     *
     * @param args custom inputs
     */
    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }
}
