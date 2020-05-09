package com.example.order.test;

import java.util.concurrent.TimeUnit;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2020-03-05 11:22
 */
public class ThreadLocalTest {

    static ThreadLocal<Inner> threadLocal = new ThreadLocal<>();

    static {
        Inner inner = new Inner();
        inner.setName("zhangsna");
        threadLocal.set(inner);
    }

    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                Inner inner = threadLocal.get();
                inner.setName("lisi");
            }
        }).start();

    }
}

class Inner{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}