package com.yaoyao.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * com.yaoyao.reflect.PrivateCar的color变量和drive()方法都是私有的，
 * 通过类实例变量无法再外部访问私有变量、调用私有方法
 * 但通过反射机制则可以绕过这个限制
 *
 * Created by yaoyao on 2019-01-27.
 */
public class PrivateCarReflect {

    public static void main(String[] args) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try {
            Class<?> clazz = loader.loadClass("com.yaoyao.reflect.PrivateCar");
            PrivateCar pCar = (PrivateCar) clazz.newInstance();

            Field colorFld = clazz.getDeclaredField("color");
            //取消Java语言访问检查以访问private变量
            colorFld.setAccessible(true);
            colorFld.set(pCar, "红色");

            Method driveMtd = clazz.getDeclaredMethod("drive", (Class[]) null);
            //取消Java语言访问检查以访问protected方法
            driveMtd.setAccessible(true);
            driveMtd.invoke(pCar, (Object[]) null);

        } catch (Exception e) {
            System.out.println("反射访问私有变量异常：" + e);
        }
    }

}
