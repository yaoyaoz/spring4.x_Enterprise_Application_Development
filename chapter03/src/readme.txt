小工具
srcAdd.jsp:查看jvm从哪个类包中加载指定类
用法：把srcAdd.jsp放到Web应用的根路径洗，访问：
http://localhost:8080/srcAdd.jsp?className=com.yaoyao.dao.UserDao即可

第三章：Spring Boot
1、启动：
建了两个文件：
chapter03\pom.xml:
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.3.3.RELEASE</version>
    </parent>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
com.yaoyao.web.BbsDaemon
就启动起来了，神奇的spring boot。
启动com.yaoyao.web.BbsDaemon.main，在浏览器访问http://localhost:8080，
即可在页面上显示“欢迎光临瑶瑶论坛！
注意：
springBoot应用如果是建在项目的一个module里面，直接右键启动，会找不到有视图的页面（如jsp），会一直报404错误；
所以基于springBoot的应用在开发调试的时，
一定要基于springBoot提供的spring-boot-maven-plugin插件命令来运行应用或通过springBoot命令来运行应用。

启动这两个方法都可以，如果要在Maven Project——>Plugins——>spring-boot里面启动，就要注释一个方法：
com.yaoyao.web.BbsDaemon.main
com.yaoyao.Application.main

在地址栏输入：http://localhost:8080/health
可以访问springboot提供的健康状态信息


笔记：
1、chapter03\pom.xml添加了spring-boot-maven-plugin之后：
    刷新idea右边的Maven Project——>Plugins就可以看到spring-boot命令了
    在默认情况下，springboot会采用内嵌的tomcat运行当前项目。
    如果想使用jetty，则需要在依赖中添加一个jetty启动器（spring-boot-starter-jetty）即可

2、chapter03\pom.xml:
\org\springframework\boot\spring-boot-dependencies\1.3.3.RELEASE\spring-boot-dependencies-1.3.3.RELEASE.pom:
    <spring.version>4.2.5.RELEASE</spring.version>
<properties>
    <!-- 父类指定了spring的版本为<spring.version>4.2.5.RELEASE</spring.version>，这里可以修改，但是改成4.2.2后，启动会报错 -->
    <spring.version>4.2.2.RELEASE</spring.version>
</properties>

3、修改默认端口号：
    \resources\application.properties：server.port

问题：
1、pom文件加了spring-boot-starter-jetty之后，在Maven Project——>Plugins里面没看到有jetty启动呢？

2、com.yaoyao.Application.txManager:这个自定义事务管理有啥用呢？

3、com.yaoyao.Application.configure(extends SpringBootServletInitializer):在实际开发中，我没配过这个也？


chapter04：
在浏览器访问http://localhost:8080/resource.html，即可在页面显示src/main/webapp/WEB-INF/jsp/resource.jsp的内容
file1.txt
C:\Users\HOME\AppData\Local\Temp\tomcat.3227100764823608252.8080\work\Tomcat\localhost\ROOT