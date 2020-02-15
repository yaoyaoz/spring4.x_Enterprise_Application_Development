package com.yaoyao.advice.advice3_around;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 环绕增强：前、后
 *
 * Created by yaoyao on 2020-02-15.
 */
public class GreetingInterceptor implements MethodInterceptor {

    //截获目标类方法的执行，并在前后添加横切逻辑
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        //目标方法入参
        Object[] args = methodInvocation.getArguments();
        String clientName = (String) args[0];

        //前置
        System.out.println("目标方法执行前调用：How are you! Mr." + clientName + ".");

        //通过反射机制调用目标方法
        Object obj = methodInvocation.proceed();

        //后置
        System.out.println("目标方法执行后调用：Please enjoy yourself!");

        return obj;
    }

}
