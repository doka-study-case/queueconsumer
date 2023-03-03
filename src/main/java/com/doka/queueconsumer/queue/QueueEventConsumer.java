package com.doka.queueconsumer.queue;

import com.doka.queueconsumer.service.LogService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class QueueEventConsumer {

    @Autowired
    LogService logService;

    @Autowired
    Gson gson;

    @RabbitListener(queues = "${doka.rabbit.log.queue}")
    public void eventLogListener(String logJson) {
        log.info("log received {}", logJson);

        logService.save(logJson);
    }

}
