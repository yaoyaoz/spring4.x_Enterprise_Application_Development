package com.yaoyao.advisor.advisor2;

import com.yaoyao.advisor.advisor1.Seller;
import com.yaoyao.advisor.advisor1.Waiter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 静态正则表达式方法匹配切面
 *
 * Created by yaoyao on 2020-02-16.
 */
public class TestRegexpAdvisor {

    @Test
    public void regexpAdvisor() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("advisor/beans2-regexp.xml");
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        Seller seller = (Seller) ctx.getBean("seller");
        waiter.greetTo("John");
        waiter.serveTo("John");
        seller.greetTo("John");
    }

}
