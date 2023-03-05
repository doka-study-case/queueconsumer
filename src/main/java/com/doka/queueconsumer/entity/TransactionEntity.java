package com.doka.queueconsumer.entity;

import com.doka.queueconsumer.enums.TransferType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
@Getter
@Setter
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_id_seq")
    @SequenceGenerator(name = "transaction_id_seq", sequenceName = "transaction_id_seq", allocationSize = 1)
    private Long id;

    @NotNull
    private TransferType transferType;

    @NotNull
    @Column(name = "customer_id")
    private Long customerId;

    @NotNull
    private BigDecimal amount;

    @Column(name = "source_account_id")
    private Long sourceAccountId;

    @Column(name = "target_account_id")
    private Long targetAccountId;

    private String corporation;

    @Column(name = "transaction_date",
            columnDefinition = "TIMESTAMP WITH TIME ZONE",
            insertable = false, updatable = false
    )
    private LocalDateTime transactionDate;

}
