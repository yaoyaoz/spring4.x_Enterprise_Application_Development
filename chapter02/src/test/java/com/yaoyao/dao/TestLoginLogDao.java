package com.yaoyao.dao;

import com.yaoyao.domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * LoginLogDao的测试类
 *
 * Created by yaoyao on 2018-12-02.
 */
@ContextConfiguration("classpath*:/yaoyao-context.xml")
public class TestLoginLogDao extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private LoginLogDao loginLogDao;

    @Test
    public void testInsertLoginLog() {
        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(1111);
        loginLog.setIp("127.0.0.1");
        int insertCount = loginLogDao.insertLoginLog(loginLog);
        System.out.println(insertCount);
    }

}
