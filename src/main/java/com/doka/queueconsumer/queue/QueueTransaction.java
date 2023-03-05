package com.doka.queueconsumer.queue;

import com.doka.queueconsumer.enums.TransferType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class QueueTransaction {

    private Long customerId;
    private BigDecimal amount;
    private Long sourceAccountId;
    private Long targetAccountId;
    private String corporation;
    private TransferType transferType;
    private LocalDateTime transactionDate;

}