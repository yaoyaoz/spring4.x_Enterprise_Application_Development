package com.yaoyao.ioc.attributeInjection;

import com.yaoyao.ioc.GeLi;

/**
 * 剧本
 *
 * 通过Setter方法注入革离饰演者（属性注入） 推荐这种方式
 *
 * Created by yaoyao on 2020-01-11.
 */
public class MoAttack2 {

    private GeLi geli1;

    //属性注入方法
    public void setGeli(GeLi geli) {
        this.geli1 = geli;
    }

    public void cityGateAsk() {
        geli1.responseAsk("通过属性Setter方法注入：墨者革离！");
    }

}
