package com.yaoyao.ioc.constructorInjection;

import com.yaoyao.ioc.GeLi;
import com.yaoyao.ioc.LiuDeHua;
import org.junit.Test;

/**
 * Created by yaoyao on 2020-01-11.
 */
public class Director1 {

    @Test
    public void direct() {
        //指定角色的饰演者
        GeLi geli = new LiuDeHua();
        //注入具体饰演者到剧本中
        MoAttack1 moAttack1 = new MoAttack1(geli);

        moAttack1.cityGateAsk();
    }

    /* 输出：
    通过构造函数注入：墨者革离！
     */

}
