package com.yaoyao.ioc;

import org.junit.Test;

/**
 * 剧本
 * <p>
 * Created by yaoyao on 2018-12-16.
 */
public class MoAttack {

    public void cityGateAsk() {
        //演员直接侵入剧本
        LiuDeHua ldh = new LiuDeHua();
        ldh.responseAsk("墨者革离！");
    }

}
