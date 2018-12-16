package com.yaoyao.ioc;

/**
 * 剧本
 * <p>
 * Created by yaoyao on 2018-12-16.
 */
public class MoAttack implements ActorArrangable {

    private GeLi geLi;

    public void injectGeLi(GeLi geLi) {
        this.geLi = geLi;
    }

    public void cityGateAsk() {
        geLi.responseAsk("墨者革离！");
    }

}
