package com.yaoyao.advice.advice5_introduce;

/**
 * 业务类
 *
 * Created by yaoyao on 2020-02-15.
 */
public class ForumService {

    public void removeTopic(int topicId) {
        System.out.println("模拟删除Topic记录：" + topicId);
        try {
            Thread.currentThread().sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void removeForum(int forumId) {
        System.out.println("模拟删除Forum记录：" + forumId);
        try {
            Thread.currentThread().sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
