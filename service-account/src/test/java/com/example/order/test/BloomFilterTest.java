//package com.example.order.test;
//
//
//import com.google.common.hash.BloomFilter;
//import com.google.common.hash.Funnels;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @program: springcloud
// * @description: 布隆过滤器测试
// * @author: jiaxiaotong
// * @create: 2020-01-07 11:20
// */
//public class BloomFilterTest {
//
//    public static void main(String[] args) {
//        int size = 2 << 25;
//        BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(),
//                size,
//                0.01);
//        List<Integer> bigList = new ArrayList<>(size);
//        for (int i = 0; i < (size); i++) {
//            bigList.add(i);
//            bloomFilter.put(i);
//        }
//        int a = 578925;
//        long listBefore = System.currentTimeMillis();
//        System.out.println("是否包含:"+bigList.contains(a));
//        long listAfter = System.currentTimeMillis();
//        System.out.println("使用list判断包含花费了"+(listAfter-listBefore));
//
//        long filterBefore = System.currentTimeMillis();
//        System.out.println("是否包含:"+bloomFilter.mightContain(a));
//        long filterAfter = System.currentTimeMillis();
//        System.out.println("使用布隆过滤器判断包含花费了"+(filterAfter-filterBefore));
//
//
//
//
//    }
//}