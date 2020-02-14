package com.yaoyao.proxy.proxy3_cglib;

import com.yaoyao.proxy.proxy2_jdk.ForumServiceImpl;
import org.junit.Test;

/**
 * 测试CGLib创建的代理类：
 * 通过CglibProxy为ForumServiceImpl类创建代理对象，并测试代理对象的方法
 *
 * 注：cglib采用动态创建子类的方法生成代理对象，所以不能对目标类中的final或private方法进行代理
 *
 * Created by yaoyao on 2020-02-14.
 */
public class TestForumService {

    @Test
    public void proxy() {
        CglibProxy proxy = new CglibProxy();
        //通过动态生成子类的方式创建代理类
        ForumServiceImpl forumService = (ForumServiceImpl) proxy.getProxy(ForumServiceImpl.class);
        forumService.removeForum(10);
        forumService.removeTopic(1023);
    }

}
