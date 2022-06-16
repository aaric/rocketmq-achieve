package com.sample.rocketmq.api.conroller;

import com.sample.rocketmq.api.TestApi;
import com.sample.rocketmq.msg.MySource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController
 *
 * @author Aaric, created on 2022-06-16T10:34.
 * @version 0.4.0-SNAPSHOT
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/test")
public class TestController implements TestApi {

    @Autowired
    private MySource mySource;

    @GetMapping("/hello")
    @Override
    public String helloGet(@RequestParam String name) {
        System.err.println(mySource);
        return String.format("hello, %s!", name);
    }
}
