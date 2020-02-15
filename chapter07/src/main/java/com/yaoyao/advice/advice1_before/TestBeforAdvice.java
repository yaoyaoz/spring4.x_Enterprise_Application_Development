package com.yaoyao.advice.advice1_before;

import org.junit.Test;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 在服务员队伍中应用礼貌用语的规定：
 * com.yaoyao.advice.GreetingBeforeAdvice#before
 *
 * Created by yaoyao on 2020-02-14.
 */
public class TestBeforAdvice {

    /**
     * 通过ProxyFactory代理工厂来代理
     */
    @Test
    public void before() {
        Waiter target = new NaiveWaiter();
        BeforeAdvice advice = new GreetingBeforeAdvice();

        //1、spring提供的代理工厂
        ProxyFactory pf = new ProxyFactory();

//        pf.setInterfaces(target.getClass().getInterfaces()); //指定对接口进行代理。将使用JDK动态代理技术
//        pf.setOptimize(true); //启用优化。还将使用CglibAopProxy代理

        //2、设置代理目标
        pf.setTarget(target);

        //3、为代理目标添加增强
        pf.addAdvice(advice);
//        pf.addAdvice(...);
//        pf.addAdvice(...);
//        pf.addAdvice(int, Advice); 指定添加位置

        //4、生成代理实例
        Waiter proxy = (Waiter) pf.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("Tom");
    }

    /**
     * 通过spring的配置文件配置代理
     */
    @Test
    public void beforeByXml() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("advice/beans1-before.xml");
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        waiter.greetTo("Lucy");
    }

}
