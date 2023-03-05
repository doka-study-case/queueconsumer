package com.doka.queueconsumer.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "notification")
@Getter
@Setter
public class NotificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notification_id_seq")
    @SequenceGenerator(name = "notification_id_seq", sequenceName = "notification_id_seq", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "customer_id")
    private Long customerId;

    @NotBlank
    private String message;

    @Column(name = "notification_date",
            columnDefinition = "TIMESTAMP WITH TIME ZONE",
            insertable = false, updatable = false
    )
    private LocalDateTime notificationDate;

}
