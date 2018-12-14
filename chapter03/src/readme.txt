1、启动：
建了两个文件：
chapter03\pom.xml
com.yaoyao.web.BbsDaemon
就启动起来了，神奇的spring boot。
启动com.yaoyao.web.BbsDaemon.main，在浏览器访问http://localhost:8080，
即可在页面上显示“欢迎光临瑶瑶论坛！


问题：
1、spring的默认容器是什么呢？
    就配了pom.xml和com.yaoyao.web.BbsDaemon，
    也没有配tomcat或者jetty，springboot默认的容器是tomcat还是jetty呢？


chapter04：
在浏览器访问http://localhost:8080/resource.html，即可在页面显示src/main/webapp/WEB-INF/jsp/resource.jsp的内容
file1.txt
C:\Users\HOME\AppData\Local\Temp\tomcat.3227100764823608252.8080\work\Tomcat\localhost\ROOT