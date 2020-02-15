package com.yaoyao.advice.advice4_throws;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;
import java.sql.SQLException;

/**
 * 异常抛出增强
 *
 * ThrowsAdvice：没有定义任何方法，它是一个标签接口
 *
 * Created by yaoyao on 2020-02-15.
 */
public class TransactionManager implements ThrowsAdvice {

    //afterThrowing方法可以写多个
    public void afterThrowing(Method method, Object[] args, Object target, Exception ex) throws Throwable {
        System.out.println("异常抛出增强====>");
        System.out.println("method:" + method.getName());
        System.out.println("抛出异常Exception：" + ex.getMessage());
        System.out.println("成功回滚事务。");
    }

    public void afterThrowing(Method method, Object[] args, Object target, SQLException ex) throws Throwable {
        System.out.println("异常抛出增强====>");
        System.out.println("method:" + method.getName());
        System.out.println("抛出异常SQLException：" + ex.getMessage());
        System.out.println("成功回滚事务。");
    }

    public void afterThrowing(SQLException ex) throws Throwable {
        System.out.println("异常抛出增强====>");
        System.out.println("..抛出异常SQLException：" + ex.getMessage());
        System.out.println("成功回滚事务。");
    }

}
