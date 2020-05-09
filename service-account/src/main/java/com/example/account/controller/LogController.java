package com.example.account.controller;

import com.example.account.domain.Log;
import com.example.account.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2019-12-23 16:55
 */
@Controller
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping("/listAll")
    @ResponseBody
    public String listAll(String aaa){
//        List<Customer> customers = customerService.listAll();
//        redisUtil.lSet("customers",customers);
//        Object customers1 = redisUtil.lGetIndex("customers1", 1);
//        List<Customer> customers11 = (List<Customer>) customers1;
//        System.out.println(customers11.get(0).toString());
        return "123";
    }


    @GetMapping("/add")
    @ResponseBody
    public void add(){
        Log log = new Log();
        log.setContent("fffffffffffffffffffffffffffff");
        logService.add(log);
    }
}