package com.wuhen.java;

/**
 * @Author Wuhen
 * @Description 类中方法的声明和使用
 *      方法：描述类应该具有的功能
 *        比如：Math类，sqrt()\random()\...
 *              Scanner类，nextXxx()...
 *              Arrays类,sort()\binarySearch()\toString()\equals()\...
 *
 *       方法的声明，权限修饰符 返回值类型  方法名（形参列表）｛方法体｝
 *              注意:static/final/abstract来修饰的方法。
 *
 *        关于Java规定的4种权限修饰符：private/public/缺省/protected
 *        返回值类型。有返回值/没有返回值
 *          如果方法有返回值，则必须在方法声明时，指定返回值的类型，同时方法中需要使用retur关键字
 *              来返回指定类型的变量或常量。
 *          如果方法有返回值，则方法声明时，使用void来表示。通常。没有返回值的方法中，就不需要使用return
 *              但是，如果使用的话只能return;表示结束此方法的意思
 *          方法中不能定义方法，可以调用当前类的属性或方法
 * @Date 2020/8/29
 **/
public class CustomerTest {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.eat();
    }
}

/**
 * 客户类
 */
class Customer{

    /**
     * 属性
     */
    String name;
    int age;
    boolean isMale;

    /**
     * 方法
     */
    public void eat(){
        System.out.println("客户吃饭");
    }
    public void sleep(int hour){
        System.out.println("休息了" + hour + "个小时");
    }
    public String getName(){
        return name;
    }
    public String getNation(String nation){
        String info = "我的国籍是：" + nation;
        return info;
    }

}
