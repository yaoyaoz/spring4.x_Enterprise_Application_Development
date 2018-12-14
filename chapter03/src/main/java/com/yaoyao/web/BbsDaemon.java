package com.yaoyao.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yaoyao on 2017-08-22.
 */
@RestController
@EnableAutoConfiguration
public class BbsDaemon {

    @RequestMapping("/")
    public String index() {
        return "欢迎光临瑶瑶论坛！";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(BbsDaemon.class, args);
    }

}
