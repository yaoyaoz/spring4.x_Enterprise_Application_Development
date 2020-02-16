package com.yaoyao.advisor.advisor1;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;

/**
 * 静态普通方法名匹配切面
 *
 * Created by yaoyao on 2020-02-16.
 */
public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor {

    //切点方法匹配规则：方法名为greetTo
    public boolean matches(Method method, Class<?> aClass) {
        return "greetTo".equals(method.getName());
    }

    //切点类匹配规则：为waiter的类或子类（该切面默认匹配所有的类）
    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            public boolean matches(Class<?> clazz) {
                return Waiter.class.isAssignableFrom(clazz);
            }
        };
    }
}
