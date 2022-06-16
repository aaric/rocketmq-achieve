package com.sample.rocketmq;

import com.sample.rocketmq.msg.MySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * 学习应用
 *
 * @author Aaric, created on 2022-06-14T14:50.
 * @version 0.1.0-SNAPSHOT
 */
@EnableBinding(MySource.class)
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
