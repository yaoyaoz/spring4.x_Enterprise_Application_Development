package com.yaoyao.advice.advice5_introduce;

import com.yaoyao.proxy.proxy1.PerformanceMonitor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * 引介增强
 *
 * 通过扩展DelegatingIntroductionInterceptor为目标类引入性能监视的可控功能
 *
 * Created by yaoyao on 2020-02-15.
 */
public class ControllablePerformanceMonitor extends DelegatingIntroductionInterceptor implements Monitorable {

    private ThreadLocal<Boolean> monitorStatusMap = new ThreadLocal<Boolean>();

    public void seMonitorActive(boolean active) {
        monitorStatusMap.set(active);
    }

    //拦截方法
    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        Object obj = null;

        //对于支持性能监视可控代理，通过判断其状态决定是否开启性能监控功能
        if (monitorStatusMap.get() != null && monitorStatusMap.get()) {
            PerformanceMonitor.begin(mi.getClass().getName() + "#" + mi.getMethod().getName());
            obj = super.invoke(mi);
            PerformanceMonitor.end();
        } else {
            obj = super.invoke(mi);
        }
        return obj;
    }
}
