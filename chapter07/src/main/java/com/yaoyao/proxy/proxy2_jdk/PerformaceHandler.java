package com.yaoyao.proxy.proxy2_jdk;

import com.yaoyao.proxy.proxy1.PerformanceMonitor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 从业务类ForumServiceImpl移除的性能监视横切代码放到这里
 *
 * Created by yaoyao on 2020-02-14.
 */
public class PerformaceHandler implements InvocationHandler {
    
    private Object target;

    public PerformaceHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PerformanceMonitor.begin(target.getClass().getName() + "#" + method.getName());
        Object obj = method.invoke(target, args);//通过反射方法调用业务类的目标方法
        PerformanceMonitor.end();
        return obj;
    }
    
}
