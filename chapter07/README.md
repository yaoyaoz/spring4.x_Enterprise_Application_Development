# 第7章主要内容

## 7.2 基础知识

### 7.2.1 带有横切逻辑的实例

com.yaoyao.proxy.proxy1

测试类：com.yaoyao.proxy.proxy1.TestForumService#main

### 7.2.2 JDK动态代理

com.yaoyao.proxy.proxy2_jdk

测试类：com.yaoyao.proxy.proxy2_jdk.TestForumService#proxy

### 7.2.3 CGLib动态代理

jdk创建代理有一个限制：只能为接口创建代理实例

cglib解决了这个问题

com.yaoyao.proxy.proxy3_cglib

## 7.3 创建增强类

com.yaoyao.advice

### 7.3.2 前置增强

测试类：com.yaoyao.advice.advice1_before.TestBeforAdvice

### 7.3.3 后置增强

测试类：com.yaoyao.advice.advice2_after.TestAfterAdvice

### 7.3.4 环绕增强

测试类：com.yaoyao.advice.advice3_around.TestAround

### 7.3.5 异常抛出增强

测试类：com.yaoyao.advice.advice4_throws.TestThrows

### 7.3.6 引介增强

测试类：com.yaoyao.advice.advice5_introduce.TestIntroduce

## 7.4 创建切面

### 7.4.3 静态普通方法名匹配切面

测试类：com.yaoyao.advisor.advisor1.TestGreetingAdvisor

### 7.4.4 静态正则表达式方法匹配切面

测试类：com.yaoyao.advisor.advisor2.TestRegexpAdvisor

### 7.4.5 动态切面

测试类：com.yaoyao.advisor.advisor3.TestDynamicAdvisor

### 7.4.6 流程切面

测试类：com.yaoyao.advisor.advisor4.TestControlFlow

## 7.5 自动创建代理

### 7.5.2 BeanNameAutoProxyCreator

测试类：com.yaoyao.autoproxy.autoproxy1_beanName.TestBeanNameAutoProxyCreator

### 7.5.3 DefaultAdvisorAutoProxyCreator

测试类：com.yaoyao.autoproxy.autoproxy2_default.TestDefaultAdvisorAutoProxyCreator

### 7.5.4 AOP无法增强疑难问题剖析

测试类：com.yaoyao.autoproxy.autoproxy3_issue.TestAopAware

报错，没有看





### 问题：

#### 1、ThreadLocal？

com.yaoyao.proxy.proxy1.PerformanceMonitor