package com.example.order;

import com.example.account.AccountApplication;
import com.example.account.controller.LogController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = AccountApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
////由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
//@WebAppConfiguration
public class AccountApplicationTests {
	@Autowired
	private LogController logController;

	@Before
	public void init() {
		System.out.println("开始测试-----------------");
	}

	@After
	public void after() {
		System.out.println("测试结束-----------------");

	}

	@Test
	public void test(){
		String aaa = logController.listAll("aaa");
		System.out.println(aaa);
	}

}
