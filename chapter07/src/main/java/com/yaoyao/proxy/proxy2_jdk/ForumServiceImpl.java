package com.yaoyao.proxy.proxy2_jdk;

import com.yaoyao.proxy.proxy1.ForumService;

/**
 * 包含性能监视横切代码接口的实现类
 *
 * Created by yaoyao on 2020-02-10.
 */
public class ForumServiceImpl implements ForumService {
    public void removeTopic(int topicId) {
        //横切代码抽取到切面中com.yaoyao.proxy2_jdk.PerformaceHandler
//        PerformanceMonitor.begin("com.yaoyao.proxy1.ForumServiceImpl.removeTopic");

        System.out.println("模拟删除Topic记录：" + topicId);
        try {
            Thread.currentThread().sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        PerformanceMonitor.end();
    }

    public void removeForum(int forumId) {
//        PerformanceMonitor.begin("com.yaoyao.proxy1.ForumServiceImpl.removeForum");

        System.out.println("模拟删除Forum记录：" + forumId);
        try {
            Thread.currentThread().sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        PerformanceMonitor.end();
    }
}
