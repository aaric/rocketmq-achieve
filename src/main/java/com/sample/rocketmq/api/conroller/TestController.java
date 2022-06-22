package com.sample.rocketmq.api.conroller;

import com.sample.rocketmq.api.TestApi;
import com.sample.rocketmq.config.RocketMQConfig;
import com.sample.rocketmq.msg.LogMsg;
import com.sample.rocketmq.msg.MySource;
import com.sample.rocketmq.msg.NotifyMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private MySource mySource;

    @Override
    @GetMapping("/source/send")
    public String sourceSendGet(@RequestParam String name) {
        String content = String.format("hello, %s!", name);
        Message<String> msg = MessageBuilder.withPayload(content)
                .setHeader(RocketMQConfig.DEFAULT_HEADER_NAME, "test").build();
        source.output().send(msg);
        return content;
    }

    @Override
    @GetMapping("/my/source/send")
    public String mySourceSendGet(String name) {
        String content = String.format("Nice to meet %s!", name);
        mySource.output().send(MessageBuilder.withPayload(content).build());
        return content;
    }

    @Override
    @PostMapping("my/source/send/log")
    public Boolean mySourceSendLogPost(@RequestBody LogMsg logMsg) {
        Message<LogMsg> msg = MessageBuilder.withPayload(logMsg)
                .setHeader(RocketMQConfig.DEFAULT_HEADER_NAME, LogMsg.DEFAULT_HEADER_VALUE).build();
        return mySource.output().send(msg);
    }

    @Override
    @PostMapping("my/source/send/notify")
    public Boolean mySourceSendNotifyPost(@RequestBody NotifyMsg notifyMsg) {
        Message<NotifyMsg> msg = MessageBuilder.withPayload(notifyMsg)
                .setHeader(RocketMQConfig.DEFAULT_HEADER_NAME, NotifyMsg.DEFAULT_HEADER_VALUE).build();
        return mySource.output().send(msg);
    }
}
