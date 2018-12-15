package com.yaoyao.dao;

import com.yaoyao.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by HOME on 2017-09-02.
 */
@Repository
public class UserDao {

    private JdbcTemplate jdbcTemplate;

    private final String MATCH_COUNT_SQL = " select count(*) from t_user " +
            " where user_name = ? and password = ? ";

    private final String USER_BY_USER_NAME_SQL = " select user_id, user_name, credits " +
            " from t_user where user_name= ? ";

    private final String UPDATE_LOGIN_INFO_SQL = " update t_user set " +
            " last_visit = ?, last_ip = ?, credits = ? where user_id = ? ";

    @Autowired //自动注入JdbcTemplate的Bean
    public void setjdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int getMatchCount(String userName, String password) {
        return jdbcTemplate.queryForObject(MATCH_COUNT_SQL, new Object[]{userName, password}, Integer.class);
    }

    public User findUserByUserName(final String userName) {//final String userName为什么要加个final呢？
        final User user = new User();
        jdbcTemplate.query(USER_BY_USER_NAME_SQL, new Object[]{userName}, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUserId(resultSet.getInt("user_id"));//为什么user不是final，这里就会有红叉叉呢？
                user.setUserName(userName);
                user.setCredits(resultSet.getInt("credits"));
            }
        });

        return user;
    }

    public void updateLoginInfo(User user) {
        Object[] args = new Object[]{user.getLastVisit(), user.getLastIp(), user.getCredits(), user.getUserId()};
        jdbcTemplate.update(UPDATE_LOGIN_INFO_SQL, args);
    }

}