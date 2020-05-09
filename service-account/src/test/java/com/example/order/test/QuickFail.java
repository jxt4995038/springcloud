package com.example.order.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2020-04-16 09:39
 */
public class QuickFail {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>() {{
            add("1");
            add("1");
            add("1");
        }};
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            list.add("1");
        }
//        Thread printThread = new Thread(new PrintThread(list));
//        Thread addThread = new Thread(new AddThread(list));
//        printThread.start();
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        addThread.start();

    }

}

class AddThread implements Runnable {

    private List<String> list;


    public AddThread(List<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        list.add("1");
        synchronized (list) {
            System.out.println("进入notify");
            list.notify();
        }
    }
}

class PrintThread implements Runnable {

    private List<String> list;


    public PrintThread(List<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        System.out.println("开始打印");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            try {
                System.out.println("进入wait");
                synchronized (list) {
                    list.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}