package com.yaoyao.advice.advice5_introduce;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 引介增强测试类
 *
 * Created by yaoyao on 2020-02-15.
 */
public class TestIntroduce {

    @Test
    public void introduc() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("advice/beans5-introduce.xml");
        ForumService forumService = (ForumService) ctx.getBean("forumService");

        System.out.println("------------------------默认情况下，未开启性能监视功能------------------------");
        forumService.removeForum(1);
        forumService.removeTopic(2);

        System.out.println("\n------------------------开启性能监视功能------------------------");
        Monitorable monitorable = (Monitorable) forumService;
        monitorable.seMonitorActive(true);

        forumService.removeForum(3);
        forumService.removeTopic(4);
    }

}
