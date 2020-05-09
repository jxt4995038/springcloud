package com.example.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2020-02-18 18:24
 */
public class Test2 {


    public static int two2Ten(String str) {
        return 0;
    }

    public static String ten2n(int n, int b) {
        if (n < b) {
            if (n < 10)
                return String.valueOf(n);
            else if (10 == n)
                return "A";
            else if (11 == n)
                return "B";
            else if (12 == n)
                return "C";
            else if (13 == n)
                return "D";
            else if (14 == n)
                return "E";
            else
                return "F";
        } else {
            if ((n % b) < 10)
                return ten2n(n / b, b).concat(String.valueOf(n % b));
            if ((n % b) == 10)
                return ten2n(n / b, b).concat("A");
            else if ((n % b) == 11)
                return ten2n(n / b, b).concat("B");
            else if ((n % b) == 12)
                return ten2n(n / b, b).concat("C");
            else if ((n % b) == 13)
                return ten2n(n / b, b).concat("D");
            else if ((n % b) == 14)
                return ten2n(n / b, b).concat("E");
            else
                return ten2n(n / b, b).concat("F");
        }
    }

    public static void main(String[] args) throws InterruptedException, ClassNotFoundException, IOException {
        //TODO 快速排序
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        threadLocal.set(1);
        Integer integer = threadLocal.get();

    }

    public static double caculate(int i){
        return ((double) (i*7342+7887*3))/(i+3);
    }

}