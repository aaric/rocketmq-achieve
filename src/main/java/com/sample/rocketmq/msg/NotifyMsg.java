package com.sample.rocketmq.msg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * NotifyMsg
 *
 * @author Aaric, created on 2022-06-16T11:29.
 * @version 0.4.0-SNAPSHOT
 */
@Data
@Accessors(chain = true)
@ApiModel("NotifyMsg")
public class NotifyMsg {

    public static final String DEFAULT_HEADER_VALUE = "notify";

    @ApiModelProperty(position = 1, value = "From", example = "11")
    private String from;
    @ApiModelProperty(position = 2, value = "Tos", example = "['22', '33']")
    private String[] to;
    @ApiModelProperty(position = 3, value = "Content", example = "hello notify")
    private String content;
}
