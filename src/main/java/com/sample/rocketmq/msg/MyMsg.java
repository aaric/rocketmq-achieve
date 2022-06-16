package com.sample.rocketmq.msg;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * MyMsg
 *
 * @author Aaric, created on 2022-06-16T11:29.
 * @version 0.4.0-SNAPSHOT
 */
@Data
@Accessors(chain = true)
public class MyMsg {

    private Integer id;
    private String name;
}
