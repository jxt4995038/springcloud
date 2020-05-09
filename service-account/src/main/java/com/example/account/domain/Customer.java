package com.example.account.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * @program: springcloud
 * @description: 客户
 * @author: jiaxiaotong
 * @create: 2019-12-23 16:49
 */
@Table(name = "test_customer1")
@Entity
@Data
public class Customer extends BaseDomain{

    private String name ;

    private String password;

    @Version
    private int version;

}