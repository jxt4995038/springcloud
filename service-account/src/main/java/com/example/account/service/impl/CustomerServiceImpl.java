package com.example.account.service.impl;

import com.example.account.domain.Customer;
import com.example.account.domain.Log;
import com.example.account.repository.CustomerRepository;
import com.example.account.repository.LogRepository;
import com.example.account.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2019-12-23 16:57
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private LogRepository logRepository;
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public static final ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Override
    public List<Customer> listAll() {
        return customerRepository.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void add(Customer customer){
        LocalDateTime localDateTime = LocalDateTime.now();
        String format = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        customer.setName(format);
        customerRepository.save(customer);
        Log log = new Log();
        log.setContent("11111111111");
        logRepository.save(log);
    }

    @Override
    @Transactional
    public void update(String id) {

        Customer customer = customerRepository.findById(id).orElse(null);
        customer.setName("2020111");
        customerRepository.save(customer);
        int a = 1/0;
    }
}