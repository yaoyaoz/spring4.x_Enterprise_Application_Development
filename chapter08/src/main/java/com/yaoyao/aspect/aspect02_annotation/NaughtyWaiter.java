package com.yaoyao.aspect.aspect02_annotation;

import com.yaoyao.anno.NeedTest;
import com.yaoyao.aspect.aspect01.Waiter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yaoyao on 2020-02-28.
 */
public class NaughtyWaiter implements Waiter {
    @NeedTest
    public void greetTo(String clientName) {
        System.out.println("NaughtyWaiter: greet to " + clientName + "...");
    }

    public void serveTo(String clientName) {
        System.out.println("NaughtyWaiter: serving " + clientName + "...");
    }
}
