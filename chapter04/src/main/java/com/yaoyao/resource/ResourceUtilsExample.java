package com.yaoyao.resource;

import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;

/**
 * 获取资源路径
 *
 * 注意：
 * 用Resource操作文件时，如果资源配置文件在项目发布时会被打包到jar中，
 * 那么不能是哟弄个Resource#getFile()方法，否则会抛出FileNotFoundException，
 * 但是可以使用Resource#getInputStream()方法读取。
 *
 * <p>
 * Created by yaoyao on 2020-01-11.
 */
public class ResourceUtilsExample {

    @Test
    public void getResource() {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        try {
            Resource[] resources = resolver.getResources("classpath*:conf*/file1.txt");
            if (resources != null) {
                for (Resource resource : resources) {
                    System.out.println(resource.getDescription());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
