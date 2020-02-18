package com.yaoyao.autoproxy.autoproxy3_issue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.OrderComparator;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.List;

/**
 * 启动管理器
 *
 * Created by yaoyao on 2020-02-18.
 */
public class SystemBootManager implements ApplicationListener<ContextRefreshedEvent> {

    private List<SystemBootAddon> systemBootAddons = Collections.EMPTY_LIST;

    private boolean hasRunOnce = false;

    //注入所有SystemBootAddons插件
    @Autowired(required = false)
    public void setSystemBootAddons(List<SystemBootAddon> systemBootAddons) {
        Assert.notEmpty(systemBootAddons);
        OrderComparator.sort(systemBootAddons);
        this.systemBootAddons =systemBootAddons;
    }

    //触发所有插件
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (!hasRunOnce) {
            for (SystemBootAddon systemBootAddon : systemBootAddons) {
                systemBootAddon.onReady();
                System.out.println("执行插件:" + systemBootAddon.getClass().getCanonicalName());
            }
            hasRunOnce = true;
        }else{
            System.out.println("已执行过容器启动插件集,本次忽略之.");
        }
    }
}
