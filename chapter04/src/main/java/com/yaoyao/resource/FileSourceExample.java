package com.yaoyao.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 通过PathResource（系统文件路径）和ClassPathResource（类路径）访问同一个文件资源
 *
 * Created by yaoyao on 2019-02-06.
 */
public class FileSourceExample {

    public static void main(String[] args) {
        try {
            String filePath = "F:\\workspaces\\github\\spring\\spring4.x_Enterprise_Application_Development\\chapter04\\src\\main\\resources\\conf\\file1.txt";

            //使用系统文件路径方式加载文件
            WritableResource res1 = new PathResource(filePath);

            //使用类路径方式加载文件
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
            //下面这样输出就不会乱码了：
            EncodedResource encRes = new EncodedResource(res2, "UTF-8");
            String content = FileCopyUtils.copyToString(encRes.getReader());
            System.out.println("res2 content:" + content);

            System.out.println("res1:" + res1.getFilename());
            System.out.println("res2:" + res2.getFilename());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
