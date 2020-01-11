描述：
通过本章的学习，可以独立完成一个典型的基于spring的web应用


启动方式：
搜索maven project:
双击jetty:run
在浏览器输入localhost:8000/bbs/index.html访问
默认用户名/密码：admin/1123456


已经弄明白的问题：
1、AbstractTransactionalTestNGSpringContextTests
    在测试时会自动启动事务，自动回滚
    参考com.yaoyao.dao.TestUserDao写的源码查看备注

2、src\main\resources\yaoyao-context.xml：
    1)expression=" (execution(* com.yaoyao.service..*(..)))，其中service..两个点代表service下面的包及子包

3、service层的事务注解提交会到这段代码：
    org.springframework.transaction.interceptor.TransactionAspectSupport#invokeWithinTransaction——>
    org.springframework.transaction.interceptor.TransactionAspectSupport.commitTransactionAfterReturning


问题：
1、chapter02\pom.xml：
    1)<packaging>war</packaging>有什么用么？加了这个打包会报错，所以注释掉了。报错信息如下：
        [ERROR] Failed to execute goal org.apache.maven.plugins:maven-war-plugin:2.2:war (default-war) on project chapter02: Error assembling WAR: webxml attribute is required (or pre-existing WEB-INF/web.xml if executing in update mode)
    2)<file.encoding>UTF-8</file.encoding>是能控制这个工程的编码格式么？
    3)依赖的连接池类库：commons-dbcp，数据库有用这个东西么？

2、com.yaoyao.domain.User：
    implements Serializable为什么要序列化呢？什么是序列化？这里不序列化有什么影响么？

3、com.yaoyao.dao.UserDao.setJdbcTemlate:@Autowired
    还可以在方法上注入？

4、com.yaoyao.dao.UserDao.findUserByUserName:
    final String userName为什么要加个final呢？

5、com.yaoyao.dao.UserDao.findUserByUserName：
    为什么user不是final，这里就会有红叉叉呢？
    这个RowCallbackHandler是怎么回调的呢？

6、src\main\resources\yaoyao-context.xml：
    1)<context:component-scan base-package="com.yaoyao.dao" />spring是怎么去扫描这个包路径的呢？
    2)<bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate" 这个id好像没有地方有用到，我把id="jdbcTemplate"删了，跑单元测试com.yaoyao.dao.TestUserDao.testGetMatchCount依旧能过

7、com.yaoyao.service.UserServiceTest
    @Autowired写在setUserService和userService上有区别么？测试了一把，两种写法都可以

8、com.yaoyao.dao.UserDao.updateLoginInfo：
    书上那种写法会报错，不知道正确的传参应该怎么传？

9、@Service、@Repository、@Autowired等这些注解有些什么不一样的含义么？

10、AbstractTransactionalTestNGSpringContextTests：开启事务的代码在哪？

11、com.yaoyao.web.LoginController.loginCheck：
    loginCheck(HttpServletRequest request, LoginCommand loginCommand)：loginCommand参数是怎么传过来的？

12、src\main\webapp\WEB-INF\web.xml
   src\main\webapp\WEB-INF\yaoyao-servlet.xml
   不知道这两个文件里面配置的那些参数意思？

需要打断点确认的问题：
1、单元测试走的事务是在spring-test类里面的，看看从web端进入，事务提交的代码是在哪呢？
2、chapter02\pom.xml：jetty插件的
    <contextPath>/bbs</contextPath>配置如果不加，就默认采用pom.xml中设置的<artifactId>名称，测试一把
    <scanIntervalSeconds>0</scanIntervalSeconds>热部署，默认为0，表示禁用热部署，如果设为3，就是修改了代码，不用重启3秒后就自动更新了么？测试一把
3、chapter02\src\webapp\WEB-INF\jsp\login.jsp里展示的error是
    com.yaoyao.web.LoginController.loginCheck return的error，测试一把

