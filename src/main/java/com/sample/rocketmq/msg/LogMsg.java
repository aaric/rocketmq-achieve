package com.sample.rocketmq.msg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * LogMsg
 *
 * @author Aaric, created on 2022-06-21T09:57.
 * @version 0.4.0-SNAPSHOT
 */
@Data
@Accessors(chain = true)
@ApiModel("日志消息")
public class LogMsg {

    public static final String DEFAULT_HEADER_VALUE = "log";

    @ApiModelProperty(position = 1, value = "ID", example = "1")
    private Integer id;
    @ApiModelProperty(position = 2, value = "日志类型", example = "1")
    private Integer logType;
    @ApiModelProperty(position = 3, value = "内容", example = "hello log")
    private String content;
}
