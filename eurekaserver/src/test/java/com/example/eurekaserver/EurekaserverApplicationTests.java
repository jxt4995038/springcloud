package com.example.eurekaserver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EurekaserverApplicationTests {

    @Test
    public void contextLoads() {
        Map<String,Object> map = new HashMap<>(2);
        map.put("aaa","1");
        map.put("bbb","2");

    }

}
