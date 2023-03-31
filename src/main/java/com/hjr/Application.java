package com.hjr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.web.DefaultSecurityFilterChain;

import javax.servlet.Filter;
import java.util.List;

@SpringBootApplication
@MapperScan("com.hjr.mapper")
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        System.out.println("hjr");
        DefaultSecurityFilterChain defaultSecurityFilterChain = applicationContext.getBean(DefaultSecurityFilterChain.class);
        List<Filter> filters = defaultSecurityFilterChain.getFilters();
        filters.forEach(System.out::println);
    }
}
