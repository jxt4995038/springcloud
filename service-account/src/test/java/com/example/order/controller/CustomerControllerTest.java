package com.example.order.controller;

import com.example.order.AccountApplicationTests;
import com.example.account.domain.Customer;
import com.example.account.service.CustomerService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;


@Transactional
@Rollback(value = false)
public class CustomerControllerTest extends AccountApplicationTests {

    @Autowired
    private CustomerService customerService;

    @Test
    public void test(){
        Customer customer = new Customer();
        customer.setName("aaa");
        customer.setPassword("123");
        try {
            customerService.add(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testList(){
        System.out.println(customerService.listAll().size());
    }

}