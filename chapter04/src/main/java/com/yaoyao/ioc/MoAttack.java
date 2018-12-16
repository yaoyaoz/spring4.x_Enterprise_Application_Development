package com.yaoyao.ioc;

/**
 * 剧本
 *
 * Created by yaoyao on 2018-12-16.
 */
public class MoAttack {

    private GeLi geLi;

    //属性注入方法
    public void setGeLi(GeLi geLi) {
        this.geLi = geLi;
    }

    public void cityGateAsk() {
        geLi.responseAsk("墨者革离！");
    }

}
