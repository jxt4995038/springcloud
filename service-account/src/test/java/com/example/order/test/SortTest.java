package com.example.order.test;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2020-02-03 22:12
 */
public class SortTest {

    public static void main(String[] args) {
        Integer[] numbers = new Integer[]{10,4,3,6,8,3,9,7,1,2,5};

        arrays2List(numbers);
//        int[] numbers = new int[]{10,4,3,6,8,3,9,7,1,2,5};
//        int[] ints = bubbleSort(numbers);
//        for (int i = 0; i < ints.length; i++) {
//            System.out.println(i);
//        }

    }

    public static int[] bubbleSort(int[] numbers){
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[j]<numbers[j]+1){
                    numbers[j] = numbers[j] ^ numbers[j+1];
                    numbers[j] = numbers[j] ^ numbers[j+1];
                    numbers[j] = numbers[j] ^ numbers[j+1];
                }
            }
        }
        return numbers;
    }

    public static void arrays2List(Integer[] numbers){
        List<Integer> objects = new ArrayList<>();
        Collections.addAll(objects,numbers);
    }
}