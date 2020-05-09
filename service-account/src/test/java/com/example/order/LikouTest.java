package com.example.order;

import java.util.*;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2020-02-25 10:48
 */
public class LikouTest {

    public static void main(String[] args) {
//        int[] numbers = new int[]{3,2,4};
//        countItems(numbers,6);
        int[] numbers = new int[]{0,0,0};
        List<List<Integer>> lists = threeSum(numbers);
        System.out.println("a");
    }


    //给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
    public static int[] countItems(int[] nums, int target) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                return new int[]{i, map.get(num)};
            }
            map.put(nums[i], i);

        }
        return new int[]{0, 0};
    }

//        public static List<List<Integer>> threeSum(int[] nums) {
//        int length = nums.length;
//        List<List<Integer>> list = new ArrayList<>();
//        if (length<3){
//            return list;
//        }
//
//
////        Set<String> needntLoop = new HashSet<>();
//        List<String> finalResultStr = new ArrayList<>();
//
//        for (int i = 0; i < length; i++) {
//            int numI = nums[i];
////            if (needntLoop.contains(numI)) {
////                continue;
////            }
//            for (int j = 1; j < length; j++) {
//                int numJ = nums[j];
////                if (needntLoop.contains(numJ)) {
////                    continue;
////                }
//                int sum = numI+numJ;
//                for (int k = 0; k < nums.length; k++) {
//                    int numK = nums[k];
////                    if (needntLoop.contains(k)) {
////                        continue;
////                    }
//                    if (numK + sum ==0) {
//                        if (numI > numJ) {
//                            int t = numI;  /*如果a<b时候 a、b数值互换*/
//                            numI = numJ;
//                            numJ = t;
//                        }
//                        if (numI > numK) {    /*如果a<c时候 a、c数值互换*/
//                            int t = numI;
//                            numI = numK;
//                            numK = t;
//                        }
//                        if (numJ > numK) {    /*如果b<c时候 b、c数值互换*/
//                            int t = numJ;
//                            numJ = numK;
//                            numK = t;
//                        }
//                        String s = numI+""+numJ+""+numK;
//                        if (finalResultStr.contains(s)) {
//                            continue;
//                        }
//                        finalResultStr.add(s);
//                        List<Integer> innerList = new ArrayList<>();
//                        innerList.add(numI);
//                        innerList.add(numJ);
//                        innerList.add(numK);
//                        list.add(innerList);
//
////                        needntLoop.add(numI);
////                        needntLoop.add(numJ);
////                        needntLoop.add(numK);
//                    }
//                }
//
//            }
//        }
//        return list;
//    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();

        int length = nums.length;
        if (length<3)
            return resultList;

        Arrays.sort(nums);
        for (int i = 0; i < length; i++) {
            int nowNum = nums[i];
            if (nowNum>0) {
                return resultList;
            }
            if (i>0 && nums[i-1] == nums[i])
                continue;
            int l = i+1;
            int r = length -1;
            while (l <r){
                int sum = nowNum + nums[l]+nums[r];
                if (sum>0)
                    r--;
                else if (sum ==0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    resultList.add(list);
                    while (l<r && nums[l] == nums[l+1]) l++; // 去重
                    while (l<r && nums[r] == nums[r-1]) r--; // 去重
                    l++;
                    r--;
                }else{
                    l++;
                }
            }
        }
        return resultList;
    }

}