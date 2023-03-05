package com.doka.queueconsumer.service;

import com.doka.queueconsumer.entity.TransactionEntity;
import com.doka.queueconsumer.queue.QueueTransaction;
import com.doka.queueconsumer.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    ModelMapper modelMapper;

    public TransactionEntity saveQueueTransaction(QueueTransaction queueTransaction) {
        TransactionEntity transactionEntity = modelMapper.map(queueTransaction, TransactionEntity.class);
        return transactionRepository.save(transactionEntity);
    }

}
