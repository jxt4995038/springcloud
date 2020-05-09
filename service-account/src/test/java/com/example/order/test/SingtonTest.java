package com.example.order.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2020-04-24 13:10
 */
public class SingtonTest {

    private static SingtonTest singtonTest = null;

    public static SingtonTest getSington(){
        if (singtonTest ==null){
            singtonTest = new SingtonTest();
        }
        return singtonTest;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(getSington());
                }
            });
        }
    }
}