描述：
通过本章的学习，可以独立完成一个典型的基于spring的web应用

启动方式：
搜索maven project:
双击jetty:run
在浏览器输入localhost:8000/bbs/index.html访问

问题：
1、chapter02\pom.xml：
    <packaging>war</packaging>有什么用么？
    <file.encoding>UTF-8</file.encoding>是能控制这个工程的编码格式么？
    依赖的连接池类库：commons-dbcp，数据库有用这个东西么？

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
    3)expression=" (execution(* com.yaoyao.service..*(..)))，其中service..两个点代表service下面的所有子包么？

7、com.yaoyao.service.UserServiceTest
    @Autowired写在setUserService和userService上有区别么？测试了一把，两种写法都可以

8、com.yaoyao.dao.UserDao.updateLoginInfo：
    书上那种写法会报错，不知道正确的传参应该怎么传？


问题：待解决：
    事务配置加了之后，提交update就不生效了

5、@Service、@Repository、@Autowired等这些注解有些什么不一样的含义么？

6、com.yaoyao.service.UserService#loginSuccess
    @Transactional 保持事务一致性？


