package com.service.test.thread;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2020-03-20 14:35
 */
public class VolatileTest extends Thread {
    private static boolean flag = false;

    public void run() {
        while (!flag){

        }
    }

    public static void main(String[] args) throws Exception {
        new VolatileTest().start();
        Thread.sleep(2000);
        flag = true;
    }
}