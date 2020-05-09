package com.example.account.conf;

import com.example.account.domain.Customer;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2020-02-12 16:17
 */

public class CustomerFormatterConfig implements Formatter<Customer> {

    @Override
    public Customer parse(String text, Locale locale) throws ParseException {
        return null;
    }

    @Override
    public String print(Customer object, Locale locale) {
        return object.getName()+"123";
    }
}