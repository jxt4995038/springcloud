//package com.example.order.test;
//
//import java.math.BigDecimal;
//import java.math.BigInteger;
//import java.util.List;
//
///**
// * @program: springcloud
// * @description:
// * @author: jiaxiaotong
// * @create: 2020-04-07 10:14
// */
//
//public class Solution {
//    public static void main(String[] args) {
//        ListNode listNode1 = new ListNode(2);
//        ListNode listNode2 = new ListNode(4);
//        ListNode listNode3 = new ListNode(3);
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//
//        ListNode listNode4 = new ListNode(5);
//        ListNode listNode5 = new ListNode(6);
//        ListNode listNode6 = new ListNode(4);
//        listNode4.next = listNode5;
//        listNode5.next = listNode6;
//
//        ListNode listNode7 = new ListNode(9);
//        ListNode listNode8 = new ListNode(1);
//        listNode8.next = new ListNode(9);
////        ListNode listNode = addTwoNumbers(listNode7, listNode8);
//
//        ListNode listNode10 = new ListNode(1);
//        ListNode listNodeTemp = listNode10;
//        for (int i = 0; i < 29; i++) {
//            ListNode listNode9 = new ListNode(0);
//            listNodeTemp.next = listNode9;
//            listNodeTemp = listNode9;
//        }
//        listNodeTemp.next = new ListNode(1);
//
//        ListNode listNode11 = new ListNode(5);
//        ListNode listNode9 = new ListNode(6);
//        ListNode listNode12 = new ListNode(4);
//        listNode11.next = listNode9;
//        listNode9.next = listNode12;
//        ListNode listNode13 = addTwoNumbers(listNode10, listNode11);
//
//        System.out.println("A");
//    }
//
//
//    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
//
//        while (l1.next!=null && l2.next!=null){
//
//        }
//        int x = l1.val;
//        int y = l2.val;
//        boolean flag = false;
//        while (x+y>=10){
//
//        }
//    }
//
//
//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//
//    }
//
//        static  class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode(int x) {
//            val = x;
//        }
//    }
//}