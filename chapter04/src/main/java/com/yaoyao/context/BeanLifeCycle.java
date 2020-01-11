package com.yaoyao.context;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 让容器装载配置文件，分别注册两个后处理器
 * <p>
 * Created by yaoyao on 2019-05-18.
 */
public class BeanLifeCycle {

    private static void lifeCycleInBeanFactory() {
        //装载配置文件并启动容器
        Resource res = new ClassPathResource("context/bean.xml");
        BeanFactory bf = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((DefaultListableBeanFactory) bf);
        reader.loadBeanDefinitions(res);

        //向容器中注册MyBeanPostProcessor后处理器
        ((ConfigurableBeanFactory) bf).addBeanPostProcessor(new MyBeanPostProcessor());

        //向容器中注册MyInstantiationAwareBeanPostProcessor后处理器
        ((ConfigurableBeanFactory) bf).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

        //第一次从容器中获取car，将触发容器实例化该Bean，这将引发Bean生命周期方法的调用
        Car car1 = (Car) bf.getBean("car");
        car1.introduce();
        car1.setColor("红色");

        //第二次从容器中获取car，直接从缓存池中获取
        Car car2 = (Car) bf.getBean("car");

        //查看car1和car2是否直接指向同一引用
        System.out.println("car1==car2:" + (car1 == car2));

        //关闭容器
        ((DefaultListableBeanFactory) bf).destroySingletons();
    }

    public static void main(String[] args) {
        lifeCycleInBeanFactory();
    }

}