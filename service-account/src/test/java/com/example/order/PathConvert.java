package com.example.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2020-02-18 17:55
 */
public class PathConvert {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String next = scanner.next();
            System.out.println(convert(next));
        }
    }

    public static String convert(String path){
        if (path ==null || path.length() <1) {
            return "/";
        }
        if (path.startsWith("/.") && path.length()>2) {
            path = path.substring(2);
        }
        if (path.startsWith("/..") && path.length()>3) {
            path = path.substring(3);
        }
        List<String> list = new ArrayList<>();
        String[] split = path.split("/");
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            if (!"".equals(s)){
                if ("..".equals(s)){
                    if (list.size()>1) {
                        list.remove(list.size()-1);
                    }
                }else if (".".equals(s)){
                    continue;
                }else {
                    list.add(s);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append("/");
            sb.append(s);
        }
        return sb.toString();
    }

}