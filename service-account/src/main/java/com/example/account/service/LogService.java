package com.example.account.service;

import com.example.account.domain.Log;

import java.util.List;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2019-12-23 16:57
 */
public interface LogService {

    List<Log> listAll();

     void add(Log log);


}