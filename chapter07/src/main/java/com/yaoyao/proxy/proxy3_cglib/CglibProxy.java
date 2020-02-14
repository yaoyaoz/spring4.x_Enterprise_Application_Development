package com.yaoyao.proxy.proxy3_cglib;

import com.yaoyao.proxy.proxy1.PerformanceMonitor;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLib：
 * 为任何类创建织入性能监视横切逻辑代理对象的代理创建器
 * <p>
 * Created by yaoyao on 2020-02-14.
 */
public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz) {
        //设置需要创建子类的类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        //通过字节码技术动态创建子类实例
        return enhancer.create();
    }

    //拦截父类所有方法的调用
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        PerformanceMonitor.begin(obj.getClass().getName() + "#" + method.getName());
        Object result = proxy.invokeSuper(obj, args);//通过代理类调用父类中的方法
        PerformanceMonitor.end();
        return result;
    }

}
