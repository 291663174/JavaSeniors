package com.wuhen.java1;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author Wuhen
 * @Description 获取运行时类的方法结构
 * @date 2020-10-13 18:43
 **/
public class MethodTest {

    @Test
    public void test1() {
        Class clazz = Person.class;
        //getMethods():获取当前运行时类及其所有父类中声明为public权限的方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println();

        //declaredMethods():获取当前运行时类中声明的所有方法  （不包含父类中声明的方法）
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method);
        }
    }

    /**
     * @Xxxx 权限修饰符  返回值类型  方法名（参数类型1 形参名1，...） throws XxxException{}
     **/
    @Test
    public void test2() {

        Class clazz = Person.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            //1.获取方法声明的注解
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }

            //2.权限修饰符
            System.out.println(Modifier.toString(method.getModifiers()) + "\t");

            //3.返回值类型
            System.out.println(method.getReturnType().getName() + "\t");

            //4.方法名
            System.out.println(method.getName());
            System.out.print("(");

            //5.形参列表
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (!(parameterTypes == null && parameterTypes.length == 0)) {
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (i == parameterTypes.length - 1) {
                        System.out.print(parameterTypes[i].getName() + " args_ " + i);
                        break;
                    }
                    System.out.print(parameterTypes[i].getName() + " args_ " + i + ",");
                }
            }

            System.out.print(")");

            //6.抛出的异常
            Class[] exceptionTypes = method.getExceptionTypes();
            if (!(exceptionTypes == null && exceptionTypes.length == 0)){
                System.out.println("throw ");
                for(int i = 0; i < exceptionTypes.length; i++){
                    System.out.print(exceptionTypes[i].getName() + ",");
                }
            }

            System.out.println();
        }


    }

}
