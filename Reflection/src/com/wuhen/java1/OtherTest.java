package com.wuhen.java1;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;

/**
 * @author Wuhen
 * @Description
 * @date 2020-10-13 22:10
 **/
public class OtherTest {
    /**
     *  获取构造器结构
     **/
    @Test
    public void test1(){
        Class clazz = Person.class;
        //getConstructors():获取当前运行时类中声明为public的构造器
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors){
            System.out.println(constructor);
        }
        System.out.println();
        //getDeclaredConstructors():获取当前运行时类中声明的所有的构造器
        Constructor[] declaredConstructirs = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors){
            System.out.println(constructor);
        }
    }

    /**
     *  获取运行时类的带泛型的父类的泛型
     *  代码：逻辑性代码 vs 功能性代码
     **/
    @Test
    public void test3(){
        Class clazz = Person.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        //获取泛型类型
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        System.out.println(((Class)actualTypeArguments[0]).getTypeName());
//        System.out.println(actualTypeArguments[0].getTypeName());
    }

    /**
     *  获取运行时类实现的接口
     **/
    @Test
    public void test5(){
        Class clazz = Person.class;
        Class[] interfaces = clazz.getInterfaces();
        for (Class c : interfaces){
            System.out.println(c);
        }
        System.out.println();
        //获取运行时类的父类实现的接口
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
    }


    /**
     *  获取运行时类所在的包
     **/
    @Test
    public void test6(){
        Class clazz = Person.class;
        Package aPackage = clazz.getPackage();
        System.out.println(aPackage);
    }

    /**
     *  获取运行时类声明的注解
     **/
    @Test
    public void test7(){
        Class clazz = Person.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations){
            System.out.println(annotation);
        }
    }
}
