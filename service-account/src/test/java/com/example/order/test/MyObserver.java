package com.example.order.test;

import java.util.Observable;
import java.util.Observer;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2020-02-25 10:12
 */
public class MyObserver implements Observer {

    private String name;

    public MyObserver(Observable o, String name) {
         o.addObserver(this);
         this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("观察者" + name + "触发更新！arg=" + arg + ",目标的观察者数量=" + o.countObservers());
    }
}