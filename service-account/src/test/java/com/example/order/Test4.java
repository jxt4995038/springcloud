package com.example.order;

import java.util.concurrent.TimeUnit;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2020-03-13 16:33
 */
public class Test4 implements Runnable{

    private Object object = new Object();

    public Test4(Object object) {
        this.object = object;
    }

    public static void main(String[] args) {

                Object o = new Object();
        Test4 test4 = new Test4(o);

        Thread thread = new Thread(test4);
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        synchronized (object){
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static int[] bubbleSort(int[] numbers){
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length-1-i; j++) {
                if (numbers[j]>numbers[j+1]){
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
        return numbers;
    }
}