package com.yaoyao.aspect.aspect01;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by yaoyao on 2020-02-26.
 */
@Aspect //通过该注解将PreGreetingAspect标识为一个切面
public class PreGreetingAspect {

    @Before("execution(* greetTo(..))") //定义切点和增强类型
    public void beforeGreeting() { //增强的横切逻辑
        System.out.println("@Aspect前置增强 How are you!");
    }

}
