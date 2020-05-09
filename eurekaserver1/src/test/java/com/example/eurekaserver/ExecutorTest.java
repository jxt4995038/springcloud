package com.example.eurekaserver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2020-01-02 17:08
 */
public class ExecutorTest {

    public static ExecutorService executorService = Executors.newFixedThreadPool(3);


    public static void main(String[] args) {
        ExecutorTest test1 = new ExecutorTest();
        ExecutorTest test2 = new ExecutorTest();
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock1.tryLock(4,TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t1获得了test1的锁");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    lock2.tryLock(5,TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock2.tryLock(5,TimeUnit.SECONDS);
                    System.out.println("t2获得了lock2");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("t2尝试获取lock1");
                    lock1.tryLock(5,TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock1.unlock();
                    lock2.unlock();
                }
                System.out.println("t2获取了test1的锁");}
        });
        thread1.start();
        thread2.start();

    }
}