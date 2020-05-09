package com.example.account.service.impl;

import com.example.account.domain.Log;
import com.example.account.repository.LogRepository;
import com.example.account.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2020-02-17 21:27
 */
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogRepository logRepository;
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public List<Log> listAll() {
        return null;
    }

    @Override
    public void add(Log log) {
        String id = applicationContext.getId();
        logRepository.save(log);
    }
}