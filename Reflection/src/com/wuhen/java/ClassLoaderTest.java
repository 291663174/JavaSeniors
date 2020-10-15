package com.wuhen.java;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Wuhen
 * @Description
 *  了解类的加载器
 * @date 2020-10-13 1:41
 **/
public class ClassLoaderTest {

    @Test
    public void test1(){
        //对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        //调用系统类加载器的getParent():获取拓展类加载器
        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);

        //调用系统类加载器的getParent():无法获取引导类拓展类加载器。
        //引导类加载器主要负责加载Java的核心类库，无法加载自定义类的。
        ClassLoader parentParent = parent.getParent();
        System.out.println(parentParent);

        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);
    }

    @Test
    public void test2() throws IOException {
        Properties properties = new Properties();
        //此时的文件默认在当前的module下
        //读取配置文件的方式一
        FileInputStream fileInputStream = new FileInputStream("jdbc.properties");
        properties.load(fileInputStream);

        //读取配置文件的方式二：使用ClassLoader
        //配置文件默认识别为：当前的module的src下
//        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
//        InputStream inputStream = classLoader.getResourceAsStream("jdbc1.properties");
//        properties.load(inputStream);

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        System.out.println("user = " + user + ",password = " + password);
    }

}
