package com.example.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2019-04-09 20:55
 */
@RestController("/test")
public class TestController {

    static Map<Integer,Integer> initMap = new HashMap<>();

    static {
        initMap.put(1,1);
        initMap.put(2,2);
        initMap.put(500,500);
    }

    @GetMapping("/test")
    @ResponseBody
    public String test(HttpServletRequest request){
        Integer a = Integer.valueOf(request.getParameter("a"));
        System.out.println(initMap.get(a));
        return "hello,World";
    }
}