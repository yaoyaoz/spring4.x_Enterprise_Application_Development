package com.yaoyao.proxy1;

/**
 * 用于记录性能监视信息的类
 *
 * Created by yaoyao on 2020-02-10.
 */
public class MethodPerformace {

    private long begin;

    private long end;

    private String serviceMethod;

    public MethodPerformace(String serviceMethod) {
        this.serviceMethod = serviceMethod;
        this.begin = System.currentTimeMillis();//记录目标类方法开始执行点的系统时间
    }

    public void printPerformance() {
        end = System.currentTimeMillis();
        long elapse = end - begin;
        System.out.println(serviceMethod + "花费" + elapse + "毫秒。");
    }

}
