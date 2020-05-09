package com.example.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2019-04-09 20:55
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/test")
    public String test(String name){
        System.out.println("in the method");
        return "hello,"+name;
    }
}