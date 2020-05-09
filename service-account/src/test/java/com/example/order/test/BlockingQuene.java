package com.example.order.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2020-02-14 17:02
 */
public class BlockingQuene {

    private Object[] objects = new Object[10];

    private int MAX_SIZE = 10;
    private int total;

    private Lock lock = new ReentrantLock() ;

    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();

    public boolean add(Object obj){
        try {
            lock.lock();

            while (MAX_SIZE == total){
                try {
                    full.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            objects[total] = obj;
            ++total;
            empty.signal();
        }finally {
            lock.unlock();
        }

        return true;
    }

    public Object pop(){
        try {
            lock.lock();

            while (total==0){
                try {
                    empty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            --total;
            full.signal();
            return objects[total];

        }finally {
            lock.unlock();
        }
    }


    public void resize(){

    }

    public static void main(String[] args) {
        BlockingQuene blockingQuene = new BlockingQuene();
        blockingQuene.add(1);
        blockingQuene.add(2);
        System.out.println(blockingQuene.pop());
        System.out.println(blockingQuene.pop());

    }
}