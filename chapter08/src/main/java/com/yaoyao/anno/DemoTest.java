package com.yaoyao.anno;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @Description: 访问NeedTest注解
 * @author: yaoyao
 * @date 2020-02-26
 */
public class DemoTest {

    @Test
    public void testAnno() {

        //得到ForumService对应的class对象
        Class clazz = ForumService.class;

        //得到ForumService对应的Method方法
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println("ForumService的methods个数：" + methods.length);
        for (Method method : methods) {
            //获取方法上所标注的注解对象
            NeedTest annotation = method.getAnnotation(NeedTest.class);
            if (annotation != null) {
                if (annotation.value()) {
                    System.out.println(method.getName() + "()需要测试");
                } else {
                    System.out.println(method.getName() + "()不需要测试");
                }
            }
        }

    }

}