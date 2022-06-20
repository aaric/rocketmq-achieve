package com.sample.rocketmq.api.conroller;

import com.sample.rocketmq.api.TestApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
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
    private Source source;

    @GetMapping("/source/send")
    @Override
    public String sourceSendGet(@RequestParam String name) {
        String content = String.format("hello, %s!", name);
        source.output().send(MessageBuilder.withPayload(content).build());
        return content;
    }
}
