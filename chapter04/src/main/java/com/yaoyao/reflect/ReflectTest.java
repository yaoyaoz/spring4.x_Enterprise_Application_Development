package com.yaoyao.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 通过Java反射机制以一种间接的方式操控目标类（com.yaoyao.reflect.Car）
 * <p>
 * 传统方式直接调用目标类：
 * Car car = new Car();
 * car.setBrand("红旗CA72");
 * 或者：
 * Car car = new Car("hongqiCA72", "黑色", 150);
 * <p>
 * Created by yaoyao on 2019-01-20.
 */
public class ReflectTest {

    public static Car initByDefaultConst() throws Throwable {

        //1、通过类装载器获取Car类对象
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("com.yaoyao.reflect.Car");

        //2、获取类的默认构造函数对象并通过它实例化Car
        Constructor cons = clazz.getDeclaredConstructor((Class[]) null);
        //问题：这里为什么要用Class[]呢？不加[]，运行的时候就会报错：
        //Exception in thread "main" java.lang.
        //
        // : com.yaoyao.reflect.Car.<init>(null)
        Car car = (Car) cons.newInstance();

        //3、通过反射方法设置属性
        Method setBrand = clazz.getMethod("setBrand", String.class);
        setBrand.invoke(car, "红旗CA72");
        Method setColor = clazz.getMethod("setColor", String.class);
        setColor.invoke(car, "黑色");
        Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
        setMaxSpeed.invoke(car, 200);
        return car;
    }

    public static void main(String[] args) throws Throwable {
        Car car = initByDefaultConst();
        car.introduce();
    }
    /**
     输出：
     brand:红旗CA72; color:黑色; maxSpeed:200
     */

}
