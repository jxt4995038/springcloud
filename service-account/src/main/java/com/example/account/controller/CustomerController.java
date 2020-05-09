package com.example.account.controller;

import com.example.account.domain.Customer;
import com.example.account.service.CustomerService;
//import com.example.account.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2019-12-23 16:55
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private RedisTemplate redisTemplate;
//    @Autowired
//    private RedisUtil redisUtil;
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public static ExecutorService executorService = Executors.newFixedThreadPool(10);

    @GetMapping("/listAll")
    @ResponseBody
    public String listAll(String aaa){
        List<Customer> customers = customerService.listAll();
        redisTemplate.opsForList().leftPushAll("aaa",customers);
        return "123";
    }

    @GetMapping("/listAll1")
    @ResponseBody
    public List<Customer> listAll1(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Customer customer = entityManager.find(Customer.class, "8a8089786f5b2676016f5b2688240000");
        EntityManager entityManager1 = entityManagerFactory.createEntityManager();
        Customer customer1 = entityManager1.find(Customer.class, "8a8089786f5b2676016f5b2688240000");
//        Query nativeQuery = entityManager.createNativeQuery("select * from test_customer");
//        List customers = nativeQuery.getResultList();

//        List<Customer> customers = customerService.listAll();
//        redisUtil.lSet("customers",customers);
//        Object customers1 = redisUtil.lGetIndex("customers1", 1);
//        List<Customer> customers11 = (List<Customer>) customers1;
//        System.out.println(customers11.get(0).toString());
        return null;
    }

    @GetMapping("/add")
    @ResponseBody
    public void add(String name) throws Exception{
        Customer customer = new Customer();
        customer.setPassword("123");
        customer.setName(name);
        customerService.add(customer);
    }

    @GetMapping("/update")
    @ResponseBody
    public void update(String id){
        customerService.update(id);
    }


    @GetMapping("/saleProduct")
    public void saleProduct(){
        int count = 100;

    }


}