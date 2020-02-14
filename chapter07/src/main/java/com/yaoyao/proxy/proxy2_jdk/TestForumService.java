package com.yaoyao.proxy.proxy2_jdk;

import com.yaoyao.proxy.proxy1.ForumService;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * jdk代理测试类：
 * 通过Proxy结合PerformaceHandler创建ForumService接口的代理实例
 *
 * Created by yaoyao on 2020-02-14.
 */
public class TestForumService {

    @Test
    public void proxy() {

        //希望被代理的目标业务类
        ForumServiceImpl target = new ForumServiceImpl();

        //将目标业务类和横切代码编织在一起
        PerformaceHandler handler = new PerformaceHandler(target);

        //根据编织了目标业务逻辑和性能监视横切逻辑的InvocationHandler实例创建代理实例
        ForumService proxy = (ForumService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                handler);

        //调用代理实例
        proxy.removeForum(10);
        proxy.removeTopic(1024);

    }

}
