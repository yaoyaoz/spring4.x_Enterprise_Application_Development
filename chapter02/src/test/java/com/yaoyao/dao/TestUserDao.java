package com.yaoyao.dao;

import com.yaoyao.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.Date;

/**
 * UserDao测试类
 *
 * Created by yaoyao on 2018-12-02.
 */
@ContextConfiguration("classpath*:/yaoyao-context.xml") //启动Spring容器
public class TestUserDao extends AbstractTransactionalTestNGSpringContextTests {//AbstractTestNGSpringContextTests

    /**
     如果继承:AbstractTestNGSpringContextTests:就不会走事务

     如果继承 AbstractTransactionalTestNGSpringContextTests:
     在测试时会自动启动事务，自动回滚

     AbstractTransactionalTestNGSpringContextTests 源码查看：
     从 AbstractTransactionalTestNGSpringContextTests 点到
     org.springframework.test.context.transaction.TransactionalTestExecutionListener#afterTestMethod(org.springframework.test.context.TestContext):
     (应该是走的监听到这个类)：216行
     if ((transactionStatus != null) && !transactionStatus.isCompleted()) {
        txContext.endTransaction();
        这个方法点进去就看到回滚和提交事务的代码了(根据flaggedForRollback来判断是否回滚):
        org.springframework.test.context.transaction.TransactionContext#endTransaction()
     }

     TransactionContext的构造函数里面设置了flaggedForRollback，默认为true
     构造函数往上点，就找到了:
     org.springframework.test.context.transaction.TransactionalTestExecutionListener#isRollback(org.springframework.test.context.TestContext)：
     Rollback rollbackAnnotation = findAnnotation(testContext.getTestMethod(), Rollback.class);
     这里去找的Rollback这个注解

     所以如果继承AbstractTransactionalTestNGSpringContextTests，又想事务提交到数据库，
     就要在测试用例上加注解:@Rollback(false)
     */

    @Autowired
    private UserDao userDao;

    @Autowired  //注入Spring容器中的Bean
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    
    @Test
    public void testGetMatchCount() {
        int count1 = userDao.getMatchCount("admin", "123456");
        int count2 = userDao.getMatchCount("admin", "111");
        System.out.println(count1);
        System.out.println(count2);
    }

    @Test
    @Rollback(false)
    /**
     该测试类继承了AbstractTransactionalTestNGSpringContextTests(这个类用了注解@Transactional，事务应该不是这个注解生效的，是监听器里面的before方法开启的事务，具体的代码还不知道是哪？)，
     如果不加这个注解，flaggedForRollback默认为true，事务就不会提交
     */
    public void testUpdateLoginInfo() {
        User user = new User();
        user.setUserId(222);
        user.setLastVisit(new Date());
        user.setLastip("127.0.0.1");
        user.setCredits(6);
        int updateCount = userDao.updateLoginInfo(user);
        System.out.println("测试UserDao.updateLoginInfo更新条数：" + updateCount);
    }

}
