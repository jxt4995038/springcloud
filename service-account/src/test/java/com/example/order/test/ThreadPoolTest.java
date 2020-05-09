package com.example.order.test;


import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2020-02-05 13:35
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        int corePoolSize = 5;
        int maxNumPoolSize  =10;
        BlockingQueue<Runnable> blockingQueue = new LinkedBlockingDeque<>(10);
        RejectedExecutionHandler rejectedExecutionHandler = new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                try {
                    System.out.println(executor.getQueue().size());
                    executor.getQueue().put(r);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("etcdfs-pool-%d").build();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize,maxNumPoolSize,60L, TimeUnit.MICROSECONDS,blockingQueue,namedThreadFactory,rejectedExecutionHandler);

        while (true){
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"run");
                }
            });
        }
    }

    public  void test(){
        AtomicStampedReference atomicStampedReference = new AtomicStampedReference(1,2);
    }
}