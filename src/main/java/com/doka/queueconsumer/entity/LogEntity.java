package com.doka.queueconsumer.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "log")
@Setter
@Getter
public class LogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "log_id_seq")
    @SequenceGenerator(name = "log_id_seq", sequenceName = "log_id_seq", allocationSize = 1)
    private Long id;

    @Type(type = "jsonb")
    @Column(name = "log", columnDefinition = "json")
    private Map<String, Object> log;

    @Column(name = "log_date",
            columnDefinition = "TIMESTAMP WITH TIME ZONE",
            insertable = false, updatable = false
    )
    private LocalDateTime logDate;

}
