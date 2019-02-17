package com.yaoyao.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by yaoyao on 2019-02-06.
 */
public class FileSourceExample {

    public static void main(String[] args) {
        try {
            String filePath = "F:\\workspaces\\github\\spring4.x_Enterprise_Application_Development\\chapter04\\src\\main\\resources\\conf\\file1.txt";

            //使用系统文件路径方式加载文件
            WritableResource res1 = new PathResource(filePath);

            Resource res2 = new ClassPathResource("conf/file1.txt");

            //使用WritableResource接口写资源文件
            OutputStream stream1 = res1.getOutputStream();
            stream1.write("欢迎访问\n瑶瑶文件".getBytes());
            stream1.close();

            //使用Resource接口读资源文件
            InputStream ins1 = res1.getInputStream();
            InputStream ins2 = res2.getInputStream();

            ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
            int i;
            while ((i = ins1.read()) != -1) {
                baos1.write(i);
            }
            System.out.println("ins1:" + baos1.toString());

            ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
            int j;
            while ((j = ins2.read()) != -1) {
                baos2.write(i);
            }
            System.out.println("ins2:" + baos2.toString());//问题：为什么baos2打印出来是乱码呢？

            System.out.println("res1:" + res1.getFilename());
            System.out.println("res2:" + res2.getFilename());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
