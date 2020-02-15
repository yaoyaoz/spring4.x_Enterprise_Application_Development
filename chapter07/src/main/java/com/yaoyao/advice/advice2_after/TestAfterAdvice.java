package com.yaoyao.advice.advice2_after;

import com.yaoyao.advice.advice1_before.NaiveWaiter;
import com.yaoyao.advice.advice1_before.Waiter;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 后置增强测试类
 *
 * Created by yaoyao on 2020-02-15.
 */
public class TestAfterAdvice {

    @Test
    public void after() {
        GreetingAfterAdvice advice = new GreetingAfterAdvice();
        Waiter waiter = new NaiveWaiter();

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(waiter);
        pf.addAdvice(advice);

        Waiter proxy = (Waiter) pf.getProxy();
        proxy.greetTo("Lucy");
        proxy.serveTo("Linda");
    }
    
    @Test
    public void afterByXml() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("advice/beans2-after.xml");
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        waiter.greetTo("Lucy");
    }

}
