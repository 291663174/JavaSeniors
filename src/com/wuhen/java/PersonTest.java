package com.wuhen.java;

/**
 * @Author Wuhen
 * @Description
 * 一、设计类其实就是设计类的成员
 *     属性 = 成员变量 = field = 域、字段
 *     方法 = 成员方法 = 函数 = method
 *     创建类的对象 = 类的实例化 = 实例化类
 * 二、类和对象的使用（面向对象思想落地的实现）
 *      1.创建类：设计类的成员
 *      2.创建类的对象
 *      3。通过“对象，属性”或“对象，方法”调用对象的结构
 * 三、如果创建了一个类的多个对象，则每个对象都独立的拥有一套类的属性（非static的）
 *      意味着，如果我们修改一个对象的属性a，则不影响另外一个对象属性a的值
 * @Date 2020/8/29
 **/
//测试类
public class PersonTest {
    public static void main(String[] args) {
        //创建Person类的对象
        Person person1 = new Person();
        //调用对象的结构：属性、方法
        //调用属性：“对象，属性”
        person1.name = "Tom";
        person1.isMale = true;
        System.out.println(person1.name);

        //调用方法：“对象.方法”
        person1.eat();
        person1.sleep();
        person1.talk("Chinese");

        //***********************
        Person person2 = new Person();
        //null
        System.out.println(person2.name);
        //false
        System.out.println(person2.isMale);
        //***********************
        Person person3 = person1;
        //Tom
        System.out.println(person3.name);
        person3.age = 10;
        //10
        System.out.println(person1.age);
    }
}
class Person{
    /**
     * @Author Wuhen
     * @Description 属性
     * @Date 2020/8/29
     **/
    String name;
    int age = 1;
    boolean isMale;

    /**
     * @Author Wuhen
     * @Description 方法
     * @Date 2020/8/29
     **/
    public void eat(){
        System.out.println("人可以吃饭");
    }
    public void sleep(){
        System.out.println("人可以睡觉");
    }
    public void talk(String language){
        System.out.println("人可以说话，使用的是：" + language);
    }

}