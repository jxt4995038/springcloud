package com.example.order.test;


import java.util.*;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2020-04-03 10:16
 */
public class Main {
     static List<Integer> resultList = new ArrayList<Integer>(){{
        add(0);
        add(1);
    }};
    public static void main(String[] args)  {
        int[] numbers = new int[]{0,1,1,2,3,5,8,13};
        for (int i = 0; i < 10; i++) {
            System.out.println(f(i));
        }

    }

    public static int f(int n){

        if (n<2) {
            return resultList.get(n);
        }else {
            if (resultList.size()>n){
                return resultList.get(n);
            }else {

            }
        }
        return n;
    }

//    private static char[] showDif(String s, String t) {
//        if (t ==null || t.length()==0){
//            return null;
//        }else {
//            if (s == null || s.length()==0 ){
//                return t.toCharArray();
//            }
//        }
//        Map<Object,Integer> countMap = new HashMap<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (countMap.get(c)==null) {
//                countMap.put(c,1);
//            }else {
//                countMap.put(c,countMap.get(c)+1);
//            }
//        }
//        for (int i = 0; i < t.length(); i++) {
//            char c = t.charAt(i);
//            if (countMap.get(c)==null) {
//                return new char[]{c};
//            }else {
//                Integer integer = countMap.get(c);
//                countMap.put(c,integer-1);
//            }
//
//        }
//        char[] result = new char[t.length()];
//        int i=0;
//        for (Map.Entry<Object, Integer> objectIntegerEntry : countMap.entrySet()) {
//            if (objectIntegerEntry.getValue()!=0) {
//                result[i] =(char) objectIntegerEntry.getKey();
//                i++;
//            }
//        }
//        return result;
//    }
}