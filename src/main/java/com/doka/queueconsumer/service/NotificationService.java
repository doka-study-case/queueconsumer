package com.doka.queueconsumer.service;

import com.doka.queueconsumer.entity.NotificationEntity;
import com.doka.queueconsumer.queue.QueueNotification;
import com.doka.queueconsumer.repository.NotificationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    ModelMapper modelMapper;

    public NotificationEntity saveQueueNotification(QueueNotification queueNotification) {
        NotificationEntity notificationEntity = modelMapper.map(queueNotification, NotificationEntity.class);
        return notificationRepository.save(notificationEntity);
    }

}
