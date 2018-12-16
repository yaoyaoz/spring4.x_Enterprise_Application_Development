package com.yaoyao.ioc;

import org.junit.Test;

/**
 * 剧本
 *
 * Created by yaoyao on 2018-12-16.
 */
public class MoAttack {

    private GeLi geLi;

    //注入革离的具体饰演者
    public MoAttack(GeLi geLi) {
        this.geLi = geLi;
    }

    public void cityGateAsk() {
        geLi.responseAsk("墨者革离！");
    }

}
