//package com.example.order.test;
//
//
//import org.springframework.util.StringUtils;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @program: springcloud
// * @description:
// * @author: jiaxiaotong
// * @create: 2020-04-15 14:16
// */
// class Reading {
//    private int a = 1;
//    private static int b = 100;
//    public static Reading instance = new Reading();
//
//    static {
//        b = 200;
//        instance.change();
//    }
//
//    public Reading() {
//        this.a = 2;
//        b = 300;
//    }
//
//    private void change() {
//        this.a = 3;
//    }
//
//    public int sum() {
//        return a + b;
//    }
//}
//
//public class TestReading {
//    public static void main(String[] args) {
//        System.out.println(Reading.instance.sum());
//        System.out.println(new Reading().sum());
////        System.out.println(firstAloneChar("ABBCCDD"));
//    }
//
//
////    public static char firstAloneChar(String str) {
////        if (StringUtils.isEmpty(str)) {
////            return '\0';
////        }
////        Map<Integer,Integer> map = new HashMap<>();
////        for (int i = 0; i < str.length(); i++) {
////            int c = (int)str.charAt(i);
////            if (map.get(c)==null) {
////                map.put(c,1);
////            }else {
////                map.put(c,map.get(c)+1);
////            }
////        }
////        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
////            if (integerIntegerEntry.getValue().equals(1)) {
////                return (char)integerIntegerEntry.getKey().intValue();
////            }
////        }
////        return '\0';
////    }
//
//    //3个台阶 每次最多上n个台阶
//    public int climbStairs(int count, int n) {
//
//    }
//}
//
