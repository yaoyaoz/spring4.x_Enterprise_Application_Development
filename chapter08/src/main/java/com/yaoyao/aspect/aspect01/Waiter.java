package com.yaoyao.aspect.aspect01;

import com.yaoyao.anno.NeedTest;

/**
 * Created by yaoyao on 2020-02-26.
 */
public interface Waiter {
    @NeedTest
    public void greetTo(String clientName);

    public void serveTo(String clientName);

}
