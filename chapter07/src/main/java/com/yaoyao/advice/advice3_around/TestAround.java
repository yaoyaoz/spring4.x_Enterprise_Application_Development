package com.yaoyao.advice.advice3_around;

import com.yaoyao.advice.advice1_before.Waiter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 环绕增强测试类
 *
 * Created by yaoyao on 2020-02-15.
 */
public class TestAround {

    @Test
    public void around() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("advice/beans3-around.xml");
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        waiter.greetTo("Lucy");
        waiter.serveTo("Mike");
    }

}
