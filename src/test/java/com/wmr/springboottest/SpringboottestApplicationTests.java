package com.wmr.springboottest;

import com.wmr.springboottest.entity.Person;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * springboot的单元测试
 */

@SpringBootTest
class SpringboottestApplicationTests {
	@Autowired
	Person person;
	Logger logger = LoggerFactory.getLogger(getClass());
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

	@Test
	public void logTest(){
		logger.trace("trace log");
		logger.debug("debug log");
		logger.info("info log");
		logger.warn("warning log");
		logger.error("error log");
	}
}
