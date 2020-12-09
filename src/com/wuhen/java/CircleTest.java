package com.wuhen.java;

/**
 * @Author Wuhen
 * @Description  利用面向对象的编程方法，设计类Circle计算圆的面积
 * @Date 2020/8/29
 **/
//测试类
public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.radius = 2.2;
        //double area = circle.findArea();
        //System.out.println(area);
        circle.findArea();
    }
}
class Circle{

    /**
     * 属性
     */
    double radius;

    //求圆的面积
//    public double findArea(){
//        double area = Math.PI * radius * radius;
//        return area;
//    }
    public void findArea(){
        double area = Math.PI * radius * radius;
        System.out.println("圆的面积为：" + area);
    }
}