package com.yaoyao.advice.advice2_after;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * 后置增强
 *
 * Created by yaoyao on 2020-02-15.
 */
public class GreetingAfterAdvice implements AfterReturningAdvice {
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("后置增强：Please enjoy yourself!");
    }
}
