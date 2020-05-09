package com.example.order;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2020-03-03 14:31
 */
public class BlockList {

    private Object[] node;

    private int total;

    private static final int maxSize = 10;

    private Lock lock = new ReentrantLock();

    private Condition empty = lock.newCondition();

    private Condition full = lock.newCondition();

    public BlockList(){
        node = new Object[maxSize];
    }

    public void add(Object o){
        try {
            lock.lock();
            while (total==maxSize){
                full.await();
            }
            node[total++] = o;
            empty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public Object pop(){
        Object obj = null;
        try {
            lock.lock();
            while (total ==0){
                empty.await();
            }
            total--;
            obj = node[total];
            full.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return obj;
    }
}