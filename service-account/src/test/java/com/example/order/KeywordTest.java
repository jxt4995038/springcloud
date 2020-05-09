package com.example.order;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2020-04-22 09:56
 */
public class KeywordTest {

    public static void main(String[] args) {
        int[] numbers = new int[]{1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1};
//        int[] numbers = new int[]{1,1,0,0,0,1};
//        System.out.println(1 << 2);
        List<Boolean> booleans = prefixesDivBy5(numbers);
        for (int i = 0; i < booleans.size(); i++) {
            System.out.println(booleans.get(i));
        }

//        List<Boolean> booleans1 = prefixesDivBy51(numbers);
//        for (int i = 0; i < booleans1.size(); i++) {
//            System.out.println(booleans1.get(i));
//        }
    }


    public static List<Boolean> prefixesDivBy5(int[] A) {
        int length = A.length;
        List<Boolean> results = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int num =0;
            int j = i;
            int start = 0;

            while (j>=0){
                num += A[j]*Math.pow(2,start);
                j --;
                start++;
            }
            results.add(num%5 ==0);
        }
        return results;
    }

    public static List<Boolean> prefixesDivBy51(int[] A) {
        List<Boolean> res = new ArrayList<Boolean>();
        int tail = 0;
        for(int i: A) {
            tail = tail * 2 + i;
            tail = (tail > 9) ? tail - 10 : tail;
            if(tail == 0 || tail == 5) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }

}