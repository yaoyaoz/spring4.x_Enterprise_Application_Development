1、启动：
建了两个文件：
chapter03\pom.xml
com.yaoyao.web.BbsDaemon
就启动起来了，神奇的spring boot。
启动com.yaoyao.web.BbsDaemon.main，在浏览器访问http://localhost:8080，
即可在页面上显示“欢迎光临瑶瑶论坛！

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


问题：
1、pom文件加了spring-boot-starter-jetty之后，在Maven Project——>Plugins里面没看到有jetty启动呢？

2、com.yaoyao.Application.txManager:这个自定义事务管理有啥用呢？

3、com.yaoyao.Application.configure:在实际开发中，我没配过这个也？


chapter04：
在浏览器访问http://localhost:8080/resource.html，即可在页面显示src/main/webapp/WEB-INF/jsp/resource.jsp的内容
file1.txt
C:\Users\HOME\AppData\Local\Temp\tomcat.3227100764823608252.8080\work\Tomcat\localhost\ROOT