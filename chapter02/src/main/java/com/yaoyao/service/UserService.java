package com.yaoyao.service;

import com.yaoyao.dao.LoginLogDao;
import com.yaoyao.dao.UserDao;
import com.yaoyao.domain.LoginLog;
import com.yaoyao.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yaoyao on 2017-07-16.
 */
@Service //将UserService标注为一个服务层的Bean
public class UserService {

    private UserDao userDao;

    private LoginLogDao loginLogDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setLoginLog(LoginLogDao loginLogDao) {
        this.loginLogDao = loginLogDao;
    }

    public boolean hasMatchUser(String userName, String password) {
        int matchCount = userDao.getMatchCount(userName, password);
        return matchCount > 0;
    }

    public User findUserByUserName(String userName) {
        return userDao.findUserByUserName(userName);
    }

    @Transactional
    public void loginSuccess(User user) {

        user.setCredits(5 + user.getCredits());

        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastip());
        loginLog.setLoginDate(user.getLastVisit());

        int updateCount = userDao.updateLoginInfo(user);
        System.out.println("更新条数：" + updateCount);
        int insertCount = loginLogDao.insertLoginLog(loginLog);
        System.out.println("插入条数：" + insertCount);
    }

}
