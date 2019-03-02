package com.yaoyao.beanfactory;

import com.yaoyao.reflect.Car;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 *
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

}
