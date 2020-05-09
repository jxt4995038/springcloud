package com.example.account.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2020-02-17 21:25
 */
@Entity
@Table(name = "log")
public class Log extends BaseDomain {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}