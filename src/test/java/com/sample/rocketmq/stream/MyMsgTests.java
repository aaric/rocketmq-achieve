package com.sample.rocketmq.stream;

import com.sample.rocketmq.msg.MySource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
    private MySource mySource;

    @Disabled
    @Test
    public void testSend() {
        System.err.println(mySource);
    }
}
