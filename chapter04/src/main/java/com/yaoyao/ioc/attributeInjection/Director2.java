package com.yaoyao.ioc.attributeInjection;

import com.yaoyao.ioc.GeLi;
import com.yaoyao.ioc.LiuDeHua;
import org.junit.Test;

/**
 * Created by yaoyao on 2020-01-11.
 */
public class Director2 {

    @Test
    public void direct() {
        MoAttack2 moAttack2 = new MoAttack2();

        //调用属性Setter方法注入
        GeLi geli = new LiuDeHua();
        moAttack2.setGeli(geli);

        moAttack2.cityGateAsk();
    }

    /* 输出：
    通过属性Setter方法注入：墨者革离！
     */

}
