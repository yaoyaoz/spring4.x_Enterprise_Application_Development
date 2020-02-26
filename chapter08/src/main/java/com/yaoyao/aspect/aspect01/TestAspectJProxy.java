package com.yaoyao.aspect.aspect01;

import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 通过
 *
 * Created by yaoyao on 2020-02-26.
 */
public class TestAspectJProxy {

    //方式1：通过编程的方式织入切面
    @Test
    public void proxy1() {
        Waiter target = new NaiveWaiter();
        AspectJProxyFactory factory = new AspectJProxyFactory();
        //设置目标对象
        factory.setTarget(target);
        //添加切面类
        factory.addAspect(PreGreetingAspect.class);
        //生成织入切面的代理对象
        Waiter proxy = factory.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("Tom");
    }

    //方式2：通过spring的配置织入切面
    @Test
    public void proxy2() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("aspect01/beans1.xml");
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        waiter.greetTo("Lucy");
        waiter.serveTo("Linda");
    }

    //方式3：基于Schema的aop命名空间进行配置
    @Test
    public void proxy3() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("aspect01/beans2-aop.xml");
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        waiter.greetTo("Mike");
        waiter.serveTo("Linda");
    }

}
