import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author Wuhen
 * @Description Lambda表达式的使用举例
 *    1.举例：（o1,o2） -> Integer.compare(o1,o2);
 *    2.格式：
 *          -> : Lambda操作符 或 箭头操作符
 *          -> : 左边：Lambda形参列表 （其实就是接口中的抽象方法付的形参列表）
 *          -> : 右边：Lambda体（其实就是重写的抽象方法的方法体）
 *    3.Lambda表达式的使用：（分为6种情况介绍）
 *      总结：
 *          -> : 左边：Lambda形参列表的参数类型可以省略（类型推断），如果Lambda形参列表只有一个参数，其一对（）也可以省略
 *          -> : 右边：Lambda体应该使用一对{}包裹，如果Lambda体只有一条执行语句（可能是return语句），
 *                      可以省略这一对{}和return关键字
 *    4.Lambda表达式的本质：作为接口的实例
 *
 *    5.如果一个接口中，只声明了一个抽象方法，则此接口就称为函数式接口
 * @date 2020-10-14 16:48
 **/
public class LambdaTest {

    @Test
    public void tset1(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天安门");
            }
        };

        runnable.run();

        System.out.println("********************");

        Runnable runnable2 = () -> System.out.println("我爱北京故宫");

        runnable2.run();

    }

    @Test
    public void test2(){
        Comparator<Integer> comparator1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int compare1 = comparator1.compare(32, 21);
        System.out.println(compare1);

        System.out.println("*********");

        //Lambda表达式的写法
        Comparator<Integer> comparator2 = ((o1, o2) -> Integer.compare(o1,o2));

        int compare2 = comparator2.compare(32, 21);
        System.out.println(compare2);

        System.out.println("*********");

        //方法引用的写法
        Comparator<Integer> comparator3 = Integer :: compare;

        int compare3 = comparator3.compare(32, 21);
        System.out.println(compare3);

    }

}
