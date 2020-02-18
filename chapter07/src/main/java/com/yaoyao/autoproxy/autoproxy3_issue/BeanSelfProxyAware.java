package com.yaoyao.autoproxy.autoproxy3_issue;

/**
 * Created by yaoyao on 2020-02-18.
 */
public interface BeanSelfProxyAware {
    void setSelfProxy(Object obj); //织入自身代理类接口
}
