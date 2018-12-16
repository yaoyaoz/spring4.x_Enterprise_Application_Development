package com.yaoyao.ioc;

import org.junit.Test;

/**
 * 导演：安排角色的具体饰演者
 * <p>
 * Created by yaoyao on 2018-12-16.
 */
public class Director {

    public void derect() {
        MoAttack moAttack = new MoAttack();

        //调用属性Setter方法注入
        GeLi geLi = new LiuDeHua();
        moAttack.injectGeLi(geLi);
        moAttack.cityGateAsk();
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
