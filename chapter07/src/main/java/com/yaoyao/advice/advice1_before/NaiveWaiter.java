package com.yaoyao.advice.advice1_before;

/**
 * 服务员接口实现类：
 * 简单的给顾客打招呼，直接提供服务，没有礼貌用语。
 *
 * Created by yaoyao on 2020-02-14.
 */
public class NaiveWaiter implements Waiter {
    public void greetTo(String name) {
        System.out.println("业务代码：greet to " + name + "...");
    }

    public void serveTo(String name) {
        System.out.println("业务代码：serving " + name + "...");
    }
}
