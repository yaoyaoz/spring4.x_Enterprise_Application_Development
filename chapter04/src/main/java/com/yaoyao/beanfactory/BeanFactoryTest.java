package com.yaoyao.beanfactory;

import com.yaoyao.ioc.attributeInjection.MoAttack2;
import com.yaoyao.reflect.Car;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * 通过BeanFactory装载配置文件，启动Spring IOC容器
 *
 * 通过ApplicationConext初始化
 *
 * Created by yaoyao on 2019-03-02.
 */
public class BeanFactoryTest {

    @Test
    public void getBean() throws IOException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource res = resolver.getResource("classpath:beanfactory/beans.xml");
        System.out.println(res.getURL());

        //被废弃，不建议使用
        //BeanFactory bf = new XmlBeanFactory(res);

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(res);
        System.out.println("init BeanFactory.");

        Car car = factory.getBean("car1", Car.class);
        System.out.println("car bean is ready for use!");
        car.introduce();
    }

    //剧本里面的角色geli、饰演者LiuDeHua 由geli.xml来控制（IOC控制反转）
    @Test
    public void getBean1() throws IOException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource res = resolver.getResource("classpath:beanfactory/geli.xml");
        System.out.println(res.getURL());

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(res);
        System.out.println("init BeanFactory.");

        MoAttack2 moAttack2 = factory.getBean("moAttack", MoAttack2.class);
        System.out.println("moAttack bean is ready for use!");
        moAttack2.cityGateAsk();
    }

    //ClassPathXmlApplicationContext加载配置文件（类路径）
    @Test
    public void getBean2() {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:beanfactory/beans.xml");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beanfactory/beans.xml");//两种写法都可以
        Car car = ctx.getBean("car1", Car.class);
        car.introduce();
    }

    //(文件系统路径)
    @Test
    public void getBean3() {
        //两种路径写法都可以
//        ApplicationContext ctx = new FileSystemXmlApplicationContext("F:\\workspaces\\github\\spring\\spring4.x_Enterprise_Application_Development\\chapter04\\src\\main\\resources\\beanfactory\\beans.xml");
        ApplicationContext ctx = new FileSystemXmlApplicationContext("file:F:\\workspaces\\github\\spring\\spring4.x_Enterprise_Application_Development\\chapter04\\src\\main\\resources\\beanfactory\\beans.xml");
        Car car = ctx.getBean("car1", Car.class);
        car.introduce();
    }

}
