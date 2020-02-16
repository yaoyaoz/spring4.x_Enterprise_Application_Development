package com.yaoyao.advisor.advisor3;

import com.yaoyao.advisor.advisor1.Waiter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 动态切面测试类
 * 
 * Created by yaoyao on 2020-02-16.
 */
public class TestDynamicAdvisor {
    
    @Test
    public void dynamicAdvisor() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("advisor/beans3-dynamic.xml");
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        System.out.println("---------------------------");
        waiter.serveTo("Peter");
        System.out.println("---------------------------");
        waiter.greetTo("Peter");
        System.out.println("---------------------------");
        waiter.serveTo("John");
        System.out.println("---------------------------");
        waiter.greetTo("John");
    }
    
}
