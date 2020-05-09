package com.service.test.thread;

import java.util.concurrent.TimeUnit;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2020-03-18 14:23
 */
public class ThreadF implements Runnable{
    public  static int count = 0;

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadF());
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("change value");
        count =1;
    }

    @Override
    public void run() {
        while (count==0){

        }
    }
}