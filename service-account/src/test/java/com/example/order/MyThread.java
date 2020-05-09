package com.example.order;

import java.util.concurrent.TimeUnit;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2020-03-29 22:55
 */

public class MyThread extends Thread {
    private int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            count++;
            System.out.println(Thread.currentThread().getName() + "=====");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int s=1831;
        int g = s%10;
        int sw = s/10%10;
        int b = s/100%10;
        int q = s/1000%10;
        System.out.println("个位数是:"+g+";十位数是:"+sw+";百位数是："+b+";千位数是："+q);
//        MyThread myThread = new MyThread();
//        Thread t1 = new Thread(myThread, "t1");
//        Thread t2 = new Thread(myThread, "t2");
//        Thread t3 = new Thread(myThread, "t3");
//        Thread t4 = new Thread(myThread, "t4");
//        Thread t5 = new Thread(myThread, "t5");
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//        t5.start();
//        TimeUnit.SECONDS.sleep(5);
//        System.out.println(myThread.count);
    }
}