第四章主要内容：IOC容器
4.1、IOC的类型：   墨者革离：剧本和饰演者解耦   com.yaoyao.ioc
    1)构造函数注入   虽然革离是主角，但是并不是每一场都需要他出现，所以在构造函数注入革离并不妥当   com.yaoyao.ioc.constructorInjection
    2)属性注入      推荐（导演可以根据所拍剧段的不同，按需注入相应的角色[setter方法]）   com.yaoyao.ioc.attributeInjection
    3)接口注入      不提倡（因为接口注入要额外申明一个接口，而且效果和属性注入无本质区别） com.yaoyao.ioc.interfaceInjection
    解耦，通过配置文件实例化并装配好所用的bean：com.yaoyao.beanfactory.BeanFactoryTest.getBean1
4.2、反射：com.yaoyao.reflect
4.3、资源访问（Resource接口） com.yaoyao.resource
    com.yaoyao.resource.FileSourceExample:System.out.println("ins2:" + baos2.toString());//问题：为什么baos2打印出来是乱码呢？

4.4 BeanFactory和ApplicationContext
4.4.1 BeanFactory介绍
    com.yaoyao.beanfactory.BeanFactoryTest.getBean
4.4.2 ApplicationContext介绍  com.yaoyao.context
    ApplicationContxt初始化:
    com.yaoyao.beanfactory.BeanFactoryTest.getBean2
    com.yaoyao.beanfactory.BeanFactoryTest.getBean3
    通过带@Configuration的配置类启动容器：
    com.yaoyao.context.Beans:@Configuration
    测试类：com.yaoyao.context.AnnotationApplicationContextTest.getBean

4.5 Bean的生命周期
4.5.1 BeanFactory中Bean的生命周期
    com.yaoyao.context.Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean
    com.yaoyao.context.MyInstantiationAwareBeanPostProcessor
    com.yaoyao.context.MyBeanPostProcessor
    context/bean.xml
    com.yaoyao.context.BeanLifeCycle
    运行com.yaoyao.context.BeanLifeCycle.main

4.5.2 ApplicationContext中Bean的生命周期
    com.yaoyao.context.MyBeanFactoryPostProcessor
    bean.xml没有敲，不知道怎么启动P114

问题：
1、com.yaoyao.beanfactory.BeanFactoryTest.getBean
    照着例子敲的，也没跟源码，不太理解
2、@Configuration和@repository有什么区别呢？都只是定义一个bean？
3、bean的生命周期照着敲了一下，没有详细去看周期的每一步（4.5.1）
4、ApplicationContext不知道怎么启动（4.5.2）
