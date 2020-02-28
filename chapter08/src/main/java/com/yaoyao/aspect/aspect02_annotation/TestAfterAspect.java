package com.yaoyao.aspect.aspect02_annotation;

import com.yaoyao.aspect.aspect01.NaiveWaiter;
import com.yaoyao.aspect.aspect01.Waiter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试后置切面增强：@annotation
 *
 * Created by yaoyao on 2020-02-28.
 */
public class TestAfterAspect {

    @Test
    public void pointcut() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aspect02_annotation/beans-aop.xml");
        Waiter naiveWaiter = (Waiter) ctx.getBean("naiveWaiter");
        com.yaoyao.aspect.aspect01.Waiter naughtyWaiter = (Waiter) ctx.getBean("naughtyWaiter");
        naiveWaiter.greetTo("Tom");
        naughtyWaiter.greetTo("John");
    }

}
