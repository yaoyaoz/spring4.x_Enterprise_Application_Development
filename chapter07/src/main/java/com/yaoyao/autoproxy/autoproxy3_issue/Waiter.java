package com.yaoyao.autoproxy.autoproxy3_issue;

/**
 * Created by yaoyao on 2020-02-16.
 */
public class Waiter {

    public void greetTo(String name) {
        System.out.println("waiter greet to " + name + "...");
    }

    public void serveTo(String name) {
        System.out.println("waiter serving " + name + "...");
        greetTo(name);
    }

}
