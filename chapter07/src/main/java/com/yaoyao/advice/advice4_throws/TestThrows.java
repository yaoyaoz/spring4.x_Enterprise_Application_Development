package com.yaoyao.advice.advice4_throws;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * 异常抛出增强测试类
 *
 * Created by yaoyao on 2020-02-15.
 */
public class TestThrows {

    @Test
    public void testThrows() throws SQLException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("advice/beans4-throws.xml");
        ForumService forumService = (ForumService) ctx.getBean("forumService");
        try {
            forumService.removeForum(1);
        } catch (Exception e) {
            System.out.println("removeForum异常。" + e.getMessage());
        }

        try {
            forumService.updateForum(2);
        } catch (SQLException e) {
            System.out.println("removeForum异常。" + e.getMessage());
        }

    }

}
