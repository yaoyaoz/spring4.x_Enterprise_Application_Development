package com.yaoyao.context;

import com.yaoyao.reflect.Car;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 通过带@Configuration的配置类启动容器
 *
 * Created by yaoyao on 2019-04-27.
 */
public class AnnotationApplicationContextTest {

    @Test
    public void getBean() {
        /**
         * 通过一个带@Configuration的POJO装载Bean配置
         * AnnotationConfigApplicationContext将加载Beans.class中的Bean定义并调用Beans.class中的方法实例化Bean
         */
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
        Car car = ctx.getBean("car", Car.class);
        car.introduce();//brand:红旗CA72; color:null; maxSpeed:200
    }

}
