package com.yaoyao.autoproxy.autoproxy3_issue;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.Ordered;

import java.util.Map;

/**
 * 可复用的注入装配器
 *
 * Created by yaoyao on 2020-02-18.
 */
public class BeanSelfProxyAwareMounter implements SystemBootAddon, ApplicationContextAware {

    private ApplicationContext applicationContext;

    //注入spring容器
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    //实现系统启动器接口中的装配就绪方法
    public void onReady() {
        //从容器中获取所有注入的自动代理Bean
        Map<String, BeanSelfProxyAware> proxyAwareMap = applicationContext.getBeansOfType(BeanSelfProxyAware.class);
        if (proxyAwareMap != null) {
            for (BeanSelfProxyAware beanSelfProxyAware : proxyAwareMap.values()) {
                beanSelfProxyAware.setSelfProxy(beanSelfProxyAware);
                System.out.println("注册自身被代理的实例");
            }
        }
    }

    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
