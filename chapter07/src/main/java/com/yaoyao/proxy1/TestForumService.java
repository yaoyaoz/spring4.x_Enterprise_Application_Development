package com.yaoyao.proxy1;

/**
 * 性能监视横切代码的测试类
 *
 * Created by yaoyao on 2020-02-10.
 */
public class TestForumService {

    public static void main(String[] args) {
        ForumService forumService = new ForumServiceImpl();
        forumService.removeTopic(56);
        forumService.removeForum(101);
    }

}
