package com.yaoyao.ioc;

/**
 * 饰演者
 *
 * Created by yaoyao on 2018-12-16.
 */
public class LiuDeHua implements GeLi {

    public void responseAsk(String saying) {
        System.out.println(saying);
    }

}
