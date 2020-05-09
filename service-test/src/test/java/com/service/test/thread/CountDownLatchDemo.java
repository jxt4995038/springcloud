package com.service.test.thread;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2020-03-18 14:55
 */

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @Author: 王琦 <QQ.Eamil>1124602935@qq.com</QQ.Eamil>
 * @Date: 2019-5-4 0004 9:43
 * @Description: 倒计时器示例:火箭发射
 */
public class CountDownLatchDemo implements Runnable{

    static final CountDownLatch latch = new CountDownLatch(10);

    @Override
    public void run() {
        // 模拟检查任务
        try {
            Thread.sleep(new Random().nextInt(10) * 1000);
            System.out.println("check complete");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //计数减一
            //放在finally避免任务执行过程出现异常，导致countDown()不能被执行
            latch.countDown();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        CountDownLatchDemo countDownLatchDemo = new CountDownLatchDemo();
        for (int i = 0; i <10 ; i++) {
            new Thread(countDownLatchDemo).start();
        }
        latch.await();
        System.out.println("finish");

    }
}