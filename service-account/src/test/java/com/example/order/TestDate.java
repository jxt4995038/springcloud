package com.example.order;
import com.alibaba.fastjson.JSONObject;
import com.example.account.domain.Customer;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2020-04-03 10:16
 */
public class TestDate {

    public static void main(String[] args){
        Map<String, Object> map = new HashMap<>();
        JSONObject jsonObject = specsJson();
        System.out.println("json -> " + jsonObject.toJSONString());
    }

    private static char[] showDif(String s, String t) {
        if (t ==null || t.length()==0){
            return null;
        }else {
            if (s == null || s.length()==0 ){
                return t.toCharArray();
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (s.indexOf(c)==-1) {
                return new char[]{c};
            }
        }
        return null;
    }

    public static JSONObject specsJson(){
        String str = "{\"schema\" : {\"$ref\" : \"#/defined/220.html\"}}";
        System.out.println("str:" + str);
        JSONObject json = JSONObject.parseObject(str);
        return json;
    }
}