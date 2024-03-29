package com.wmr.springboottest.config;

import com.wmr.springboottest.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration 说明当前类是一个配置类，替代之前的spring配置文件
 */
@Configuration
public class MyAppConfig {
    // @Bean注解讲方法的返回值添加到springboot容器中, 容器中bean的id就是方法名
    @Bean
    public HelloService helloService(){
        return new HelloService();
    }
}
