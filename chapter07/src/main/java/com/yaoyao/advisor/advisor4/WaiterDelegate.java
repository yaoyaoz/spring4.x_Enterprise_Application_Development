package com.yaoyao.advisor.advisor4;

import com.yaoyao.advisor.advisor1.Waiter;

/**
 * Created by yaoyao on 2020-02-16.
 */
public class WaiterDelegate {
    private Waiter waiter;

    public void service(String clientName) {
        waiter.greetTo(clientName);
        waiter.serveTo(clientName);
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }
}
