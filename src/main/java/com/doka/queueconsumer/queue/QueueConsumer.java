package com.doka.queueconsumer.queue;

import com.doka.queueconsumer.service.LogService;
import com.doka.queueconsumer.service.NotificationService;
import com.doka.queueconsumer.service.TransactionService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class QueueConsumer {

    @Autowired
    LogService logService;

    @Autowired
    TransactionService transactionService;

    @Autowired
    NotificationService notificationService;

    @Autowired
    Gson gson;

    @RabbitListener(queues = "${doka.rabbit.log.queue}")
    public void logListener(String logJson) {
        log.info("log received {}", logJson);

        logService.save(logJson);
    }

    @RabbitListener(queues = "${doka.rabbit.transaction.queue}")
    public void transactionListener(String transactionJson) {
        log.info("transaction received {}", transactionJson);

        QueueTransaction queueTransaction = gson.fromJson(transactionJson, QueueTransaction.class);
        log.info("queueTransaction {}", queueTransaction);
        transactionService.saveQueueTransaction(queueTransaction);
    }

    @RabbitListener(queues = "${doka.rabbit.notification.queue}")
    public void notificationListener(String notificationJson) {
        log.info("notification received {}", notificationJson);

        QueueNotification queueNotification = gson.fromJson(notificationJson, QueueNotification.class);
        log.info("queueNotification {}", queueNotification);
        notificationService.saveQueueNotification(queueNotification);
    }

}
