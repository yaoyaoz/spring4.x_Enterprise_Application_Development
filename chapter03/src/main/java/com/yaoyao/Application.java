package com.yaoyao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by yaoyao on 2018-12-14.
 */
//@Configuration
//@ComponentScan
//@EnableAutoConfiguration
@SpringBootApplication //在Spring Boot 1.2+中可以使用@SpringBootApplication注解代替上面3个注解
@EnableTransactionManagement //启用注解事物管理（相当于chapter02 xml中的<tx:annotation-driven/>）
public class Application {//配置springMVC框架，但是不继承这个好像也没关系呀 extends SpringBootServletInitializer

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    //这个是自定义事物管理器，有啥用呢？默认的难道不是这个么？
    @Bean
    public PlatformTransactionManager txManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    //在boot环境中配置MVC，为什么我在实际开发中没配这句代码呢？
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(Application.class);
//    }

}
