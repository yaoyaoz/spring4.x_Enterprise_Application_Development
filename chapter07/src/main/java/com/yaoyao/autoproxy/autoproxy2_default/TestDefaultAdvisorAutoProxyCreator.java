package com.yaoyao.autoproxy.autoproxy2_default;

import com.yaoyao.advisor.advisor1.Seller;
import com.yaoyao.advisor.advisor1.Waiter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 自动代理：
 * DefaultAdvisorAutoProxyCreator测试类
 *
 * Created by yaoyao on 2020-02-17.
 */
public class TestDefaultAdvisorAutoProxyCreator {

    @Test
    public void defaultAdvisorAuto() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("autoproxy/beans2-default.xml");
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        Seller seller = (Seller) ctx.getBean("seller");
        waiter.serveTo("John");
        waiter.greetTo("John");
        seller.greetTo("Tom");
    }

}
