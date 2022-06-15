package com.sample.rocketmq.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * RocketMQLocalTransactionStringListener
 *
 * @author Aaric, created on 2022-06-15T11:24.
 * @version 0.3.0-SNAPSHOT
 */
@Slf4j
@Component
@RocketMQTransactionListener(txProducerGroup = "tx-aaa")
public class RocketMQLocalTransactionStringListener implements RocketMQLocalTransactionListener {

    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        String txId = (String) msg.getHeaders().get("txId");
        log.info("executeLocalTransaction -> txId={}", txId);
        if (StringUtils.isNotEmpty(txId)) {
            return RocketMQLocalTransactionState.COMMIT;
        }
        return RocketMQLocalTransactionState.ROLLBACK;
    }

    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message msg) {
        String txId = (String) msg.getHeaders().get("txId");
        log.info("checkLocalTransaction -> txId={}", txId);
        if (StringUtils.isNotEmpty(txId)) {
            return RocketMQLocalTransactionState.COMMIT;
        }
        return RocketMQLocalTransactionState.ROLLBACK;
    }
}
