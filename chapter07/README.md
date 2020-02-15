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

com.yaoyao.advice.advice5_introduce.TestIntroduce







### 问题：

#### 1、ThreadLocal？

com.yaoyao.proxy.proxy1.PerformanceMonitor