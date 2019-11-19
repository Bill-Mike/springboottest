package com.wmr.springboottest;

import com.wmr.springboottest.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * springboot的单元测试
 */

@SpringBootTest
class SpringboottestApplicationTests {
	@Autowired
	Person person;
	@Test
	void contextLoads() {
		System.out.println(person);
	}
	@Autowired
	ApplicationContext ioc;
	@Test
	public void testHelloService(){
		boolean result = ioc.containsBean("helloService");
		System.out.println(result);
	}
}
