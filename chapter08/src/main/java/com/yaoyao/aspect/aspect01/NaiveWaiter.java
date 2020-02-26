package com.yaoyao.aspect.aspect01;

/**
 * Created by yaoyao on 2020-02-26.
 */
public class NaiveWaiter implements Waiter {

    public void greetTo(String clientName) {
        System.out.println("NaiveWaiter: greet to " + clientName + "...");
    }

    public void serveTo(String clientName) {
        System.out.println("NaiveWaiter: serving " + clientName + "...");
    }

}
