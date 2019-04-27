package com.yaoyao.context;

import com.yaoyao.reflect.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yaoyao on 2019-04-27.
 */
@Configuration //表示是一关配置信息提供类
public class Beans {

    @Bean(name = "car") //定义一个Bean
    public Car buildCar() {
        Car car = new Car();
        car.setBrand("红旗CA72");
        car.setMaxSpeed(200);
        return car;
    }

}
