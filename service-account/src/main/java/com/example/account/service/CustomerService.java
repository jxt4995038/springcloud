package com.example.account.service;

import com.example.account.domain.Customer;

import java.util.List;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2019-12-23 16:57
 */
public interface CustomerService {

    List<Customer> listAll();

    void add(Customer customer) ;

    void update(String id);

    default void aaa(Customer customer){
        System.out.println("aaa");
    }
}