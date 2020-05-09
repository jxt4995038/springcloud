package com.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@PropertySource("classpath:application.yml")
public class ServiceTestApplicationTests {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Autowired
	private RabbitAdmin rabbitAdmin;


	@Test
	public  void contextLoads() {

		rabbitAdmin.declareExchange(new FanoutExchange("fanout.exchange",true,false));
	}

}
