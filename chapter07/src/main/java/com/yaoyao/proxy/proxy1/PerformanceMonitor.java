package com.yaoyao.proxy.proxy1;

/**
 * 性能监视的实现类
 *
 * Created by yaoyao on 2020-02-10.
 */
public class PerformanceMonitor {

    private static ThreadLocal<MethodPerformace> performaceRecor = new ThreadLocal<MethodPerformace>();

    public static void begin(String method) {
        System.out.println("begin monitor...");
        MethodPerformace mp = new MethodPerformace(method);
        performaceRecor.set(mp);
    }

    public static void end() {
        System.out.println("end monitor...");
        MethodPerformace mp = performaceRecor.get();

        //打印方法性能监视的结果信息
        mp.printPerformance();
    }

}
