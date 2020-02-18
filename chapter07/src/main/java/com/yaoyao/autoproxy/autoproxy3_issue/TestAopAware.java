package com.yaoyao.autoproxy.autoproxy3_issue;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * com.yaoyao.autoproxy.autoproxy3_issue.Waiter#serveTo(java.lang.String)里面调用的greetTo不会使用增强
 *
 * Created by yaoyao on 2020-02-18.
 */
public class TestAopAware {

    @Test
    public void autoProxy() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("autoproxy/beans3-issue.xml");
        Waiter waiter = (Waiter) ctx.getBean("waiter");

        //serveTo方法里面调用的greetTo没有被增强
        waiter.serveTo("John");

        //单独调用greetTo，增强了的
        waiter.greetTo("Tom");
    }

    //解决同一个类的内部方法直接调用无法被增强的问题，但是执行报错
    @Test
    public void autoProxy1() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("autoproxy/beans3-issue.xml");
        Waiter2 waiter2 = (Waiter2) ctx.getBean("waiter2");

        //serveTo方法里面调用的greetTo没有被增强
        waiter2.serveTo("John");

        //单独调用greetTo，增强了的
        waiter2.greetTo("Tom");
    }

}
