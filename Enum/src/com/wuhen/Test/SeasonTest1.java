package com.wuhen.Test;

/**
 * @author Wuhen
 * @Description 一、枚举类的使用
 * 1.枚举类的理解：类的对象只有有限个，确定的。我们称此类为枚举类
 * 2.当需要定义一组常量时，强烈建议使用枚举类
 * 3.如果枚举类中只有一个对象，则可以作为单例模式的实现方式。
 * 二 如何定义枚举类
 * 方式一：jdk5.0之前，自定义枚举类
 * 方式二：jdk5.0时，可以使用enum关键字定义枚举类
 *
 * 三：Enum类中的常用方法
 *      value()方法：返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值。
 *      valueOf(String str):可以把一个字符串转为对应的枚举类对象。要求字符串必须是枚举类对象
 *      toString（）：返回当前枚举类对象常量的名称
 *  四、使用enum关键字定义的枚举类实现接口的情况
 *      情况一：实现接口，在enum类中实现抽象方法
 *      情况二:让枚举类的对象分别实现接口中的抽象方法
 * @date 2020-09-30 15:02
 **/
public class SeasonTest1 {
    /**
     * 1.提供当前枚举类的对象，多个对象之间用","隔开，末尾对象“；”结束
     **/
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        //Enum提供的toString类
        System.out.println(summer);

        /* System.out.println(Season1.class.getSuperclass()); */

        System.out.println("------------------------");
        //查看枚举类内部状态（对象）
        Season1[] values = Season1.values();
        for (int i = 0 ; i < values.length;i++){
            System.out.println(values[i]);
            values[i].show();
        }

        System.out.println("------------------------");
        Thread.State[] values1 = Thread.State.values();
        for (int i = 0 ; i < values1.length;i++){
            System.out.println(values1[i]);
        }

        System.out.println("------------------------");
        /**
         *  返回枚举类中对象名是objName的对象
         *  如果没有objName的枚举类对象，则抛异常IllegalArgumentException
         **/
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);
    }
}

interface Info{
    void show();
}

/**
 * 使用enum关键字定义枚举类
 **/
enum Season1 implements Info{
    /**
     * 1.提供当前枚举类的多个对象，多个对象之间用“，”隔开，末尾对象“；”结束
     **/
    SPRING("春天", "春暖花开"){
        @Override
        public void show() {
            System.out.println("春天来了");
        }
    },
    SUMMER("夏天", "夏日炎炎"){
        @Override
        public void show() {
            System.out.println("夏天来了");
        }
    },
    AUTUMN("秋天", "秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天来了");
        }
    },
    WINTER("冬天", "冰天雪地"){
        @Override
        public void show() {
            System.out.println("冬天来了");
        }
    };

    /**
     * 2.声明Season对象的属性:private final 修饰
     **/
    private final String seasonName;
    private final String seasonDesc;

    /**
     * 3.私有化类的构造器,并给对象属性赋值
     **/
    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    /**
     * 4、其他诉求1：获取枚举类对象的属性
     **/
    public String getSeasonName(){
        return seasonName;
    }

    public String getSeasonDesc(){
        return seasonDesc;
    }

//    @Override
//    public void show() {
//        System.out.println("这是一个季节");
//    }

    /**
     * 4、其他诉求2：重写toString()
     **/
//    @Override
//    public String toString() {
//        return "Season{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }
}
