package com.example.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.DriverManager;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2020-04-20 11:17
 */
@RestController
@RequestMapping("redisTest")
public class RedisReceiver {

    @Autowired
    private RedisTemplate redisTemplate;

    public void getMessage(String str){
        System.out.println(str);
    }


    @GetMapping("/publishMsg")
    public void publishMsg(){
        redisTemplate.convertAndSend("test","123");
    }
}