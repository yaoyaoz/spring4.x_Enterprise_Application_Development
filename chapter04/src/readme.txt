本章主要内容：Spring IOC容器
1、IOC的类型：   墨者革离：剧本和饰演者解耦
    1)构造函数注入   虽然革离是主角，但是并不是每一场都需要他出现，所以在构造函数注入革离并不妥当
    2)属性注入      推荐（导演可以根据所拍剧段的不同，按需注入相应的角色[setter方法]）
    3)接口注入      不提倡（因为接口注入要额外申明一个接口，而且效果和属性注入无本质区别）
2、反射：Car
3、资源访问（Resource接口）

4.4.2 ApplicationContext介绍
    com.yaoyao.context
    com.yaoyao.context.Beans:@Configuration
    测试类：com.yaoyao.context.AnnotationApplicationContextTest.getBean


问题：
1、com.yaoyao.beanfactory.BeanFactoryTest.getBean
    照着例子敲的，也没跟源码，不太理解
2、@Configuration和@repository有什么区别呢？都只是定义一个bean？


