package com.yaoyao.ioc.constructorInjection;

import com.yaoyao.ioc.GeLi;

/**
 * 剧本：
 *
 * 通过构造函数注入革离饰演者
 *
 * Created by yaoyao on 2020-01-11.
 */
public class MoAttack1 {

    private GeLi geli;

    //注入革离的具体饰演者
    public MoAttack1(GeLi geli) {
        this.geli = geli;
    }

    public void cityGateAsk() {
        geli.responseAsk("通过构造函数注入：墨者革离！");
    }
}
