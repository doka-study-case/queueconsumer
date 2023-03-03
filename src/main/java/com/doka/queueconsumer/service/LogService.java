package com.doka.queueconsumer.service;

import com.doka.queueconsumer.entity.LogEntity;
import com.doka.queueconsumer.repository.LogRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LogService {

    @Autowired
    LogRepository logRepository;

    @Autowired
    Gson gson;

    public LogEntity save(String logJson) {
        Map<String, Object> log = gson.fromJson(logJson, new TypeToken<Map<String, Object>>(){}.getType());
        LogEntity entity = new LogEntity();
        entity.setLog(log);

        return logRepository.save(entity);
    }

}
