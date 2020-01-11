package com.yaoyao.ioc.interfaceInjection;

import com.yaoyao.ioc.GeLi;

/**
 * 剧本
 *
 * 接口注入：额外定义了一个接口类ActorArrangable，效果和属性注入无本质区别，所以不提倡这种注入方式
 * <p>
 * Created by yaoyao on 2018-12-16.
 */
public class MoAttack3 implements ActorArrangable {

    private GeLi geLi;

    public void injectGeLi(GeLi geLi) {
        this.geLi = geLi;
    }

    public void cityGateAsk() {
        geLi.responseAsk("通过接口注入：墨者革离！");
    }

}
