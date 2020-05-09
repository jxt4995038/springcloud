package com.example.order.test;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2020-02-16 15:43
 */
public class MyTest {
    public static void main(String[] args) {
        // data.length >= k
        int k = 3;
        int[] data = {3, 4, 1, 6, 8, 10, -1};
        System.out.println(kLargest(data, k) == 6);
    }
    private static int kLargest(int[] data, int k) {
        // todo
//       if(k>data.length-1)
//         throw new Exception("");
        for(int i=0;i<data.length-k+1;i++){
            for(int j=0;j<data.length-i-1;j++){
                if(data[j]<data[j+1]){
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }
        return data[k];
    }
}