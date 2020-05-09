package com.example.order.test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2020-04-17 09:53
 */
public class JsonTest {

    public static void main(String[] args) throws Exception{
//        File file = new File("C:\\Users\\79960\\Desktop\\530201_330101_5300000001372867_202004050700.json");
//        ObjectMapper objectMapper = new ObjectMapper();
//        EatsAdModel o = (EatsAdModel)objectMapper.readValue(file, EatsAdModel.class);
//        System.out.println(o);

//        List<Map> mapList = new ArrayList<>();
//        for (int i = 0; i < 3; i++) {
//            Map<Object,Object> map = new HashMap();
//            map.put("id",i);
//            map.put("version","3123123123");
//            map.put("inputTime", "2020-04-17T11:36:11");
//            map.put("result",i);
//            mapList.add(map);
//        }

        Map<Object,Object> cidMap = new HashMap<>();
        cidMap.put("clearDate","2020-04-14T03:03:03");
        cidMap.put("processTime","2020-04-14T03:03:03");
        cidMap.put("amount",123);
        cidMap.put("messageCount",1);
        cidMap.put("disputedCount",2);

        List<Map> detailMapList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Map<Object,Object> detailMap = new HashMap<>();

            detailMap.put("operatorId",i);
            detailMap.put("issuerId",i);
            detailMap.put("messageCount",i);
            detailMap.put("disputedCount",i);
            detailMap.put("amount",i);
            List<Map> itemMapList = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                Map itemMap = new HashMap();
                itemMap.put("fileId",j);
                itemMap.put("serviceType",j);
                itemMap.put("fileType",j);
                itemMap.put("amount",j);
                itemMap.put("count",j);
                itemMapList.add(itemMap);
            }
            detailMap.put("clearItems",itemMapList);
            detailMapList.add(detailMap);
        }
        cidMap.put("clearDetail",detailMapList);

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(cidMap));

    }
}