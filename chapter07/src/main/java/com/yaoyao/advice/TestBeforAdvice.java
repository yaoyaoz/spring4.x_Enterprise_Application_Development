package com.yaoyao.advice;

import org.junit.Test;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

/**
 * 在服务员队伍中应用礼貌用语的规定：
 * com.yaoyao.advice.GreetingBeforeAdvice#before
 *
 * Created by yaoyao on 2020-02-14.
 */
public class TestBeforAdvice {

    @Test
    public void before() {
        Waiter target = new NaiveWaiter();
        BeforeAdvice advice = new GreetingBeforeAdvice();

        //1、spring提供的代理工厂
        ProxyFactory pf = new ProxyFactory();

        //2、设置代理目标
        pf.setTarget(target);

        //3、为代理目标添加增强
        pf.addAdvice(advice);

        //4、生成代理实例
        Waiter proxy = (Waiter) pf.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("Tom");
    }

}
