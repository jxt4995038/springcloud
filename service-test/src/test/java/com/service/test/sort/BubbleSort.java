package com.service.test.sort;

import com.google.common.collect.Lists;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * @program: springcloud
 * @description: 冒泡排序
 * @author: jiaxiaotong
 * @create: 2020-03-16 10:49
 */
public class BubbleSort {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            strings.add(i+"");
        }
        List<List<String>> partitions = Lists.partition(strings, 200);
        System.out.println(partitions.size());
//        int[] numbers = new int[]{3,5,1,6,2,7};
////        Arrays.stream(ints).forEach((e) -> System.out.println(e));
//
//        quickSort(numbers,0,numbers.length-1);
//        for (int i = 0; i < numbers.length; i++) {
//            System.out.println(numbers[i]);
//        }
    }

    public static int[] bubbleSort(int[] numbers){
        for (int i = 0; i < numbers.length -1 ; i++) {
            for (int j = 0; j < numbers.length -i-1 ; j++) {
                if (numbers[j] < numbers[j+1]){
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
        return numbers;
    }

//    public  static void quickSort(int[] numbers,int left,int right){
//        if (right-left <=1 ){
//            //只处理两个元素以上的
//            return ;
//        }
//        int basic = numbers[left];
//        int leftIndex = left;
//        int rightIndex = right;
//        while (left <right){
//            while (right >0 && right>left && numbers[right]> basic){
//                right--;
//            }
//            while (left <right && numbers[left]<=basic){
//                left++;
//            }
//            int temp = numbers[left];
//            numbers[left] = numbers[right];
//            numbers[right] = temp;
//        }
//        quickSort(numbers,leftIndex,left-1);
//        quickSort(numbers,right+1,rightIndex);
//
//    }

    private static void   quickSort(int[] numbers, int left, int right) {
        if (left >= right) {
            return;
        }
        int leftIndex = left;
        int rightIndex = right;

        int key = numbers[leftIndex];

        while (leftIndex < rightIndex) {
            while (rightIndex > leftIndex && numbers[rightIndex] >= key) {
                rightIndex--;
            }

            //找到这种元素将arr[right]放入arr[left]中
            numbers[leftIndex] = numbers[rightIndex];

            while (leftIndex < rightIndex && numbers[leftIndex] <= key) {
                //从左往右扫描，找到第一个比基准值大的元素
                leftIndex++;
            }

            //找到这种元素将arr[left]放入arr[right]中
            numbers[rightIndex] = numbers[leftIndex];
        }
        //基准值归位
        numbers[leftIndex] = key;
        //对基准值左边的元素进行递归排序
        quickSort(numbers, left, leftIndex - 1);
        //对基准值右边的元素进行递归排序。
        quickSort(numbers, rightIndex + 1, right);
    }

}