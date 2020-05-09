package com.example.order.test;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2020-02-27 14:26
 */
public class IntegerTest {

    public static void main(String[] args) {
        Integer i =1;
        Integer j =2;

        swap(i,j);
        System.out.println(i);
        System.out.println(j);
    }

    private static void swap(Integer i, Integer j) {
        Class<Integer> integerClass = Integer.class;
        Integer temp = i;
        i = j;
        j = temp;
    }
}