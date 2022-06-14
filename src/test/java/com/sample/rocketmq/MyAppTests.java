package com.sample.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * MyAppTests
 *
 * @author Aaric, created on 2022-06-14T15:09.
 * @version 0.1.0-SNAPSHOT
 */
@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class MyAppTests {

    @Value("${spring.application.name}")
    private String applicationName;

    @Test
    public void testHello() {
        log.info("hello, {}!", applicationName);
    }
}
