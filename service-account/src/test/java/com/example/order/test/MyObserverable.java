package com.example.order.test;


import java.util.Observable;


/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2020-02-25 10:13
 */
public class MyObserverable extends Observable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {//如果数据变化了
        setChanged();
        notifyObservers(name);
    }


    public static void main(String[] args) {
        MyObserverable myObserverable = new MyObserverable();
        MyObserver myObserver = new MyObserver(myObserverable,"11");
        myObserverable.setName("123");
    }
}