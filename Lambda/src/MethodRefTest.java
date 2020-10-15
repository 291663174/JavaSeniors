import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Wuhen
 * @Description  方法引用的使用
 *  1.使用情境：当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用！
 *  2.方法引用：本质上就是Lambda表达式，而Lambda表达式作为函数式接口的实例。所以方法引用也是函数式接口的实例
 *  3.使用格式：类（或对象）：：方法名
 *  4.具体分为如下的三种情况:
 *     情况1  对象 ：： 非静态方法
 *     情况2  类  ：： 静态方法
 *     情况3  类  ：： 非静态方法
 *  5.方法引用使用的要求：要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的形参列表和返回值
 *          类型相同！（针对于情况1和情况2）
 * @date 2020-10-14 19:46
 **/
public class MethodRefTest {

    //情况一：对象 ：： 实例方法
    //Consumer中的void accept(T t)
    //PrintStream中的void println(T t)
    @Test
    public void test1(){

        Consumer<String> consumer1 = s -> System.out.println(s);
        consumer1.accept("北京");

        System.out.println("*****************");

        PrintStream printStream = System.out;
        Consumer<String> consumer2 = printStream :: println;
        consumer2.accept("beijing");
    }

    //Supplier中的T get()
    //Employee中的String getName()
    @Test
    public void test2(){

        Employee employee = new Employee(1001,"Tom",23,5600);
        Supplier<String> supplier1 = () -> employee.getName();
        System.out.println(supplier1.get());

        System.out.println("*****************");

        Supplier<String> supplier2 = employee :: getName;
        System.out.println(supplier2.get());

    }

    //情况二：类 ：： 静态方法
    //Comparator中的int compare(T t1,T t2)
    //String中的int t1.compareTo(t2)
    @Test
    public void test3(){

        Comparator<Integer> comparator1 = (t1,t2) -> Integer.compare(t1,t2);
        System.out.println(comparator1.compare(12, 21));

        System.out.println("*************************");

        Comparator<Integer> comparator2 = Integer :: compare;
        System.out.println(comparator2.compare(12, 3));

    }

    //Function中的R apply(T t)
    //Math中的Long round(Double d)
    @Test
    public void test4(){

        Function<Double,Long> function = new Function<Double, Long>() {
            @Override
            public Long apply(Double d) {
                return Math.round(d);
            }
        };

        System.out.println("*******************");

        Function<Double,Long> function1 = d -> Math.round(d);
        System.out.println(function1.apply(12.3));

        System.out.println("*******************");

        Function<Double,Long> function2 = Math::round;
        System.out.println(function1.apply(12.6));

    }

    //情况三：类 ：： 实例方法
    //Comparator中的int compare(T t1,T t2)
    //String中的int t1.compareTo(t2)
    @Test
    public void test5(){

        Comparator<String> comparator1 = (s1,s2) -> s1.compareTo(s2);
        System.out.println(comparator1.compare("abd", "abd"));

        System.out.println("**************************");

        Comparator<String> comparator2 = String :: compareTo;
        System.out.println(comparator1.compare("abc", "abm"));


    }

    //BiPredicate中的Boolea test(T t1,T t2);
    //String中的boolean t1.equals(t2)
    @Test
    public void test6(){
        BiPredicate<String,String> predicate1 = (s1,s2) -> s1.equals(s2);
        System.out.println(predicate1.test("abc","abc"));
    }

    //Function中的R apply(T t)
    //Employee中的String getName();
    @Test
    public void test7(){

        Employee employee = new Employee(1001, "Jerry", 23, 5500);
        Function<Employee,String> function1 = e -> e.getName();
        //System.out.println(function1.apply(employee));

        System.out.println("*****************");

        Function<Employee,String> function2 = Employee::getName;
        //System.out.println(function2.apply(employee));

    }
}
