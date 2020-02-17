package com.yaoyao.autoproxy.autoproxy1_beanName;

import com.yaoyao.advisor.advisor1.Seller;
import com.yaoyao.advisor.advisor1.Waiter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 自动代理：
 * BeanNameAutoProxyCreator测试类
 *
 * Created by yaoyao on 2020-02-17.
 */
public class TestBeanNameAutoProxyCreator {

    @Test
    public void beanNameAuto() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("autoproxy/beans1-beanName.xml");
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        Seller seller = (Seller) ctx.getBean("seller");
        waiter.greetTo("John");
        seller.greetTo("Tom");
    }

}
