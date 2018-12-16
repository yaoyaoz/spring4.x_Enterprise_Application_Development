package com.yaoyao.ioc;

import org.junit.Test;

/**
 * 剧本
 *
 * Created by yaoyao on 2018-12-16.
 */
public class MoAttack {

    public void cityGateAsk() {
        //1、引入革离角色接口
        GeLi geLi = new LiuDeHua();

        //2、通过接口展开剧情
        geLi.responseAsk("墨者革离！");
    }

    @Test
    public void testCityGateAsk() {
        MoAttack moAttack = new MoAttack();
        moAttack.cityGateAsk();
    }
    /*
     输出：
     墨者革离！
     */

}
