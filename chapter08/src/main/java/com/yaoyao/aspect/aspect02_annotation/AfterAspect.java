package com.yaoyao.aspect.aspect02_annotation;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 后置切面增强：@annotation
 *
 * Created by yaoyao on 2020-02-28.
 */
@Aspect
public class AfterAspect {

    /*
    后置增强切面。@annotation表示标注了NeedTest注解的所有方法：
    com.yaoyao.aspect.aspect02_annotation.NaughtyWaiter.greetTo方法使用了NeedTest注解
     */
    @AfterReturning("@annotation(com.yaoyao.anno.NeedTest)")
    public void needTestFun() {
        System.out.println("后置增强@annotation：needTestFun excuted!");
    }

}
