package com.example.account.conf;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2020-02-12 16:17
 */

public class FormatterConfig implements Formatter<String> {

    @Override
    public String parse(String text, Locale locale) throws ParseException {
        System.out.println("fomatter-parse");
        return text+"123";
    }

    @Override
    public String print(String object, Locale locale) {
        System.out.println("fomatter-print");
        return object+"123123";
    }
}