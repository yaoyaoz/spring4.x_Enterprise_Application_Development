package com.yaoyao.advisor.advisor1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 静态普通方法名匹配切面测试类
 *
 * Created by yaoyao on 2020-02-16.
 */
public class TestGreetingAdvisor {

    @Test
    public void advisor() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("advisor/beans1.xml");
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        Seller seller = (Seller) ctx.getBean("seller");

        waiter.greetTo("John");
        waiter.serveTo("John");
        seller.greetTo("John");
    }

}
