    package com.yaoyao.anno;

/**
 * @Description: 使用NeedTest注解
 * @author: yaoyao
 * @date 2020-02-26
 */
public class ForumService {

    @NeedTest(value = true) //标注注解
    public void deleteForum(int forumId) {
        System.out.println("删除论坛模块：" + forumId);
    }

    @NeedTest(value = false) //标注注解
    public void deleteTopic(int postId) {
        System.out.println("删除论坛主题：" + postId);
    }

}