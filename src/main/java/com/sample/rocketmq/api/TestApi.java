package com.sample.rocketmq.api;

import com.sample.rocketmq.msg.LogMsg;
import com.sample.rocketmq.msg.NotifyMsg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * TestApi
 *
 * @author Aaric, created on 2022-06-16T10:32.
 * @version 0.4.0-SNAPSHOT
 */
@Api(tags = "TestApi")
public interface TestApi {

    @ApiOperation("source send")
    String sourceSendGet(@ApiParam("Your name") String name);

    @ApiOperation("my source send")
    String mySourceSendGet(@ApiParam("Your name") String name);

    @ApiOperation("my source send log")
    Boolean mySourceSendLogPost(@ApiParam LogMsg logMsg);

    @ApiOperation("my source send notify")
    Boolean mySourceSendNotifyPost(@ApiParam NotifyMsg notifyMsg);
}
