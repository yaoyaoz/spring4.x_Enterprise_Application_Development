package com.yaoyao.advice.advice5_introduce;

/**
 * 标识目标类是否支持性能监视的接口
 *
 * Created by yaoyao on 2020-02-15.
 */
public interface Monitorable {
    void seMonitorActive(boolean active);
}
