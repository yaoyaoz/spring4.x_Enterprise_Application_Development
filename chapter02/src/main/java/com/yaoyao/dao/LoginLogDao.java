package com.yaoyao.dao;

import com.yaoyao.domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 记录用户的登录日志
 *
 * Created by yaoyao on 2017-07-12.
 */
@Repository
public class LoginLogDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final static String INSERT_LOGIN_LOG_SQL = " insert into t_login_log(user_id, ip, login_datetime) " +
            " values(?, ?, ?) ";

    public int insertLoginLog(LoginLog loginLog) {
        Object[] args = new Object[] {loginLog.getUserId(), loginLog.getIp(), loginLog.getLoginDate()};
        return jdbcTemplate.update(INSERT_LOGIN_LOG_SQL, args);
    }

}
