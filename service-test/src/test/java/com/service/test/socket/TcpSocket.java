package com.service.test.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2020-03-17 10:40
 */
public class TcpSocket  {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integerList.add(i);
        }

        for (int i = 0; i < integerList.size(); i++) {
            System.out.println("in loop");
            if (i%2==0){
                System.out.println(i);
            }
            integerList.remove(i);

        }
    }

}