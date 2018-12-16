package com.yaoyao.ioc;

import org.junit.Test;

/**
 * 导演：安排角色的具体饰演者
 *
 * Created by yaoyao on 2018-12-16.
 */
public class Director {

    public void derect() {
        //1、指定角色的饰演者
        GeLi geLi = new LiuDeHua();

        //2、注入具体饰演者到剧本中
        MoAttack moAttack = new MoAttack(geLi);
        geLi.responseAsk("墨者革离！");
    }

    @Test
    public void testDerect() {
        Director director = new Director();
        director.derect();
    }
    /*
     输出：
     墨者革离！
     */

}
