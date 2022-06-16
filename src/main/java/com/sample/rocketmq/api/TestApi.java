package com.sample.rocketmq.api;

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

    @ApiOperation("Hello World")
    String helloGet(@ApiParam("Name") String name);
}
