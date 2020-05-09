//package com.example.order.test;
////
////import org.junit.platform.commons.util.StringUtils;
////
////import java.util.Arrays;
////import java.util.Scanner;
////
/////**
//// * @program: springcloud
//// * @description:
//// * @author: jiaxiaotong
//// * @create: 2020-04-24 15:10
//// */
////public class Test {
////
////    public static void main(String[] args) {
////        Scanner scanner = new Scanner(System.in);
////        while (scanner.hasNext()){
////            String next = scanner.next();
////            pupulate(next);
////        }
////    }
////
////    public static int pupulate(String inputStr){
////        int num = 0;
////
////        if (inputStr ==null || inputStr.length() ==0) {
////            return num;
////        }else {
////            String[] split = inputStr.split(",");
////            int length = split.length;
////
////            int[] numbers = new int[length];
////            int[] tempNumbers = new int[length];
////            for (int i = 0; i < length; i++) {
////                numbers[i] = Integer.valueOf(split[i]);
////                tempNumbers[i] = Integer.valueOf(split[i]);
////            }
////            //冒泡排序找到最小的数
////            for (int i = 0; i < 1; i++) {
////                for (int j = 0; j < length -1 -i; j++) {
////                    if (tempNumbers[j]<tempNumbers[j+1]){
////                        int temp = tempNumbers[j];
////                        tempNumbers[j] = tempNumbers[j+1];
////                        tempNumbers[j+1] = temp;
////                    }
////                }
////            }
////
////            int min = tempNumbers[length-1];
////            int minIndex =0;
////            for (int i = 0; i < length; i++) {
////                if (numbers[i] ==min) {
////                    minIndex = i;
////                    break;
////                }
////            }
////
////
////
////        }
////
////        return 0;
////    }
////
////    public static int getTotal(int minIndex,int[] numbers){
////        int[] result = new int[numbers.length];
////        result[minIndex] = 1;
////        getNum(minIndex,result);
////        if (index ==0)
////            return 1;
////    }
////
////    public static int getNum(int index,int nextIndex,int[] result){
////        int length = result.length;
////        if (length==1){
////            return 1;
////        }else if (length ==2){
////            return 3;
////        }else {
////            if (index == 0 ){
////                return getNum(index,index+1,result);
////            }else if (index == result.length){
////
////            }else {
////
////            }
////            if (result[index])
////            2,1,3
////            return getNum()
////        }
////
////    }
////}