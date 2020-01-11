package com.yaoyao.ioc.interfaceInjection;

import com.yaoyao.ioc.GeLi;
import com.yaoyao.ioc.LiuDeHua;
import org.junit.Test;

/**
 * 导演：安排角色的具体饰演者
 * <p>
 * Created by yaoyao on 2018-12-16.
 */
public class Director3 {

    public void derect() {
        MoAttack3 moAttack3 = new MoAttack3();

        //调用属性Setter方法注入
        GeLi geLi = new LiuDeHua();
        moAttack3.injectGeLi(geLi);
        moAttack3.cityGateAsk();
    }

    @Test
    public void testDerect() {
        Director3 director3 = new Director3();
        director3.derect();
    }
    /*
     输出：
     通过接口注入：墨者革离！
     */

}
