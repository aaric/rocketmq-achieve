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
@Api(tags = "测试API")
public interface TestApi {

    @ApiOperation("默认源发送字符串")
    String sourceSendGet(@ApiParam("你的名字") String name);

    @ApiOperation("自定义源发送字符串")
    String mySourceSendGet(@ApiParam("你的名字") String name);

    @ApiOperation("自定义源发送日志对象")
    Boolean mySourceSendLogPost(@ApiParam LogMsg logMsg);

    @ApiOperation("自定义源发送通知对象")
    Boolean mySourceSendNotifyPost(@ApiParam NotifyMsg notifyMsg);
}
