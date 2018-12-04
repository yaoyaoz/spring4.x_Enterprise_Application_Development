package com.yaoyao.service;

import com.yaoyao.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.Date;

/**
 * UserService的测试类
 *
 * Created by yaoyao on 2018-12-02.
 */
@ContextConfiguration("classpath*:/yaoyao-context.xml")
public class TestUserService extends AbstractTestNGSpringContextTests {

    @Autowired
    private UserService userService;

    @Test
    public void testLoginSuccess () {
        User user = new User();
        user.setUserId(222);
        user.setLastip("127.0.0.1");
        user.setLastVisit(new Date());
        user.setCredits(1);
        userService.loginSuccess(user);
        System.out.println("测试UserService.loginSuccess完成");
    }

}
