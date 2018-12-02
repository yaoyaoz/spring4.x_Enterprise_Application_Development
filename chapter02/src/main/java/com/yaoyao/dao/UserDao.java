package com.yaoyao.dao;

import com.yaoyao.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 访问User的DAO
 * <p>
 * Created by yaoyao on 2017-07-05.
 */
@Repository //通过Spring注解定义一个DAO
public class UserDao {

    private JdbcTemplate jdbcTemlate;

    private final String MATCH_COUNT_SQL = " select count(*) from t_user " +
            " where user_name = ? and password = ? ";

    private final String USER_BY_USER_NAME_SQL = " select user_id, user_name, credits " +
            " from t_user where user_name= ? ";

        private final String UPDATE_LOGIN_INFO_SQL = " update t_user set " +
            " last_visit = ?, last_ip = ?, credits = ? where user_id = ? ";

    @Autowired //自动注入JdbcTemplate的Bean
    public void setJdbcTemlate(JdbcTemplate jdbcTemlate) {
        this.jdbcTemlate = jdbcTemlate;
    }

    /**
     * 根据用户名和密码获取匹配的用户数
     *
     * @param userName 用户名
     * @param password 密码
     * @return 1：表示用户名/密码正确；0：表示用户名或密码错误
     */
    public int getMatchCount(String userName, String password) {
        return jdbcTemlate.queryForObject(MATCH_COUNT_SQL, new Object[]{userName, password}, Integer.class);
    }

    /**
     * 根据用户名获取User对象
     *
     * @param userName 用户名
     * @return
     */
    public User findUserByUserName(final String userName) {//final String userName为什么要加个final呢？
        final User user = new User();
        jdbcTemlate.query(USER_BY_USER_NAME_SQL, new Object[]{userName}, new RowCallbackHandler() {
            //这个RowCallbackHandler是怎么回调的呢？
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUserId(resultSet.getInt("user_id"));//为什么user不是final，这里就会有红叉叉呢？
                user.setUserName(userName);
                user.setCredits(resultSet.getInt("credits"));
            }
        });

        return user;
    }

    /**
     * 更新用户积分、最后登录IP及最后登录时间
     *
     * @param user
     */
    public int updateLoginInfo(final User user) {
//        不知道为什么这种写法会报错：org.springframework.jdbc.BadSqlGrammarException: PreparedStatementCallback; bad SQL grammar [ update t_user set user_name=?, credits=? where user_id=222]; nested exception is java.sql.SQLException: No value specified for parameter 2
//        Object args = new Object[]{user.getLastVisit(), user.getLastip(), user.getCredits(), user.getUserId()};
//        return jdbcTemlate.update(UPDATE_LOGIN_INFO_SQL, args);

        return jdbcTemlate.update(UPDATE_LOGIN_INFO_SQL, new PreparedStatementSetter() {
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setDate(1, new Date(user.getLastVisit().getTime()));
                ps.setString(2, user.getLastip());
                ps.setInt(3, user.getCredits());
                ps.setInt(4, user.getUserId());
            }
        });

    }

}
