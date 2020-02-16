package com.yaoyao.advisor.advisor4;

import com.yaoyao.advisor.advisor1.Waiter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 流程切面测试类
 *
 * Created by yaoyao on 2020-02-16.
 */
public class TestControlFlow {

    @Test
    public void controlFlow() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("advisor/beans4-controlFlow.xml");
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        WaiterDelegate wd = new WaiterDelegate();
        wd.setWaiter(waiter);
        waiter.serveTo("Peter");
        waiter.greetTo("Peter");
        wd.service("John");
    }

}
