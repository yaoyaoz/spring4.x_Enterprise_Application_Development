package com.yaoyao.dao;

import com.yaoyao.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.Date;

/**
 * UserDao测试类
 *
 * Created by yaoyao on 2018-12-02.
 */
@ContextConfiguration("classpath*:/yaoyao-context.xml") //启动Spring容器
public class TestUserDao extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private UserDao userDao;

    @Autowired  //注入Spring容器中的Bean
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    
    @Test
    public void testGetMatchCount() {
        int count1 = userDao.getMatchCount("admin", "123456");
        int count2 = userDao.getMatchCount("admin", "111");
        System.out.println(count1);
        System.out.println(count2);
    }

    @Test
    public void testUpdateLoginInfo() {
        User user = new User();
        user.setUserId(222);
        user.setLastVisit(new Date());
        user.setLastip("127.0.0.1");
        user.setCredits(3);
        int updateCount = userDao.updateLoginInfo(user);
        System.out.println("测试UserDao.updateLoginInfo更新条数：" + updateCount);
    }

}
