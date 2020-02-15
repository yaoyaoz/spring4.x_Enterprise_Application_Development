package com.yaoyao.advice.advice4_throws;

import java.sql.SQLException;

/**
 * 异常抛出增强的业务类
 *
 * Created by yaoyao on 2020-02-15.
 */
public class ForumService {

    public void removeForum(int forumId) {
        //do sth...
        throw new RuntimeException("运行时异常RuntimeException。");
    }

    public void updateForum(int  forumId) throws SQLException {
        //do sth...
        throw new SQLException("数据库更新异常SQLException");
    }

}
