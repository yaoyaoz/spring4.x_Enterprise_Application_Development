package com.yaoyao.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 对NaiveWaiter的服务进行规范：
 * 让他们在打招呼和提供服务之前，必须先对顾客使用礼貌用语。
 *
 * Created by yaoyao on 2020-02-14.
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {

    //在目标类方法调用前执行
    public void before(Method method, Object[] args, Object o) throws Throwable {
        String clientName = (String) args[0];
        System.out.println("How are you! Mr." + clientName + ".");
    }

}
