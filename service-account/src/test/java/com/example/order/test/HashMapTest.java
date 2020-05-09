package com.example.order.test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2020-02-05 20:39
 */
public class HashMapTest implements Runnable{

    private static boolean flag = true;

    public  int count;

    public static void main(String[] args) {
        HashMapTest hashMapTest = new HashMapTest();
        for (int i = 0; i < 10; i++) {
            new Thread(hashMapTest).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(hashMapTest.count);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            count++;
        }
    }
}