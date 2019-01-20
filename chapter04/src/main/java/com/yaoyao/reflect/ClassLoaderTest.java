package com.yaoyao.reflect;

/**
 * 类装载器ClassLoader：
 * JVM在运行时会产生3个ClassLoader：
 * 根装载器、
 * ExtClassLoader(扩展类装载器)、
 * AppClassLoader(应用类装载器)
 *
 * Created by yaoyao on 2019-01-20.
 */
public class ClassLoaderTest {

    /**
     * 从输出结果可以看出：
     * 当前的ClassLoader是AppClassLoader，
     * 其父ClassLoader是ExtClassLoader,
     * 祖父ClassLoader是根装载器，因为在java中无法获得它的句柄，所以仅返回null
     * @param args
     */
    public static void main(String[] args) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println("current loader:" + loader);
        System.out.println("parent loader:" + loader.getParent());
        System.out.println("grandparent loader:" + loader.getParent().getParent());
    }
    /**
     输出：
     current loader:sun.misc.Launcher$AppClassLoader@14dad5dc
     parent loader:sun.misc.Launcher$ExtClassLoader@677327b6
     grandparent loader:null
     */

}
