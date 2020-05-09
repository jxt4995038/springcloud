package com.service.test.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2020-03-17 10:08
 */
public class ThreadTest implements Runnable{


    private static Lock lock = new ReentrantLock();


    public void lockTest(){
        lock.lock();
        System.out.println("in locked block");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }

    @Override
    public void run() {
        lockTest();
    }

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        ThreadTest threadTest1 = new ThreadTest();

        Thread thread = new Thread(threadTest);
        Thread thread1 = new Thread(threadTest);
        thread.start();
        thread1.start();
    }
}