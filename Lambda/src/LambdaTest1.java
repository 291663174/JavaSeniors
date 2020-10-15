import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author Wuhen
 * @Description
 * @date 2020-10-14 17:40
 **/
public class LambdaTest1 {

    //语法格式一：无参，无返回值
    @Test
    public void test1(){
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

    //语法格式二：Lambda需要一个参数但是没有返回值。
    @Test
    public void test2(){
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("谎言和誓言的区别是什么？");

        System.out.println("***********");

    }

    //语法格式三：数据类型可以省略，因为可由编译器推断得出，称为“类型推断”
    @Test
    public void test3(){

        Consumer<String> consumer1 = (String s) -> {
            System.out.println(s);
        };
        consumer1.accept("一个是听的人当真了，一个是说的人当真了");

        System.out.println("*************");

        Consumer<String> consumer2 = (s) -> {
            System.out.println(s);
        };
        consumer2.accept("一个是听的人当真了，一个是说的人当真了");
    }

    @Test
    public void test4(){
        
        //类型推断
        ArrayList<String> arrayList = new ArrayList<>();
        int[] arr = {1,2,3};
    }

    //语法格式四：Lambda若只需要一个参数时，参数的小括号可以省略。
    @Test
    public void test5(){

        Consumer<String> consumer = (s) -> {
            System.out.println(s);
        };
        consumer.accept("一个是听的人当真了，一个是说的人当真了");

        System.out.println("*****************");

        Consumer<String> consumer2 = s -> {
            System.out.println(s);
        };
        consumer2.accept("一个是听的人当真了，一个是说的人当真了");

    }

    //语法格式五:Lambda 需要两个或以上的参数，多条执行语句，并且可以有返回值
    @Test
    public void test6(){

        Comparator<Integer> comparator1 = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        System.out.println(comparator1.compare(12, 21));

        System.out.println("*****************");

        Comparator<Integer> comparator2 = (o1,o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        System.out.println(comparator1.compare(12,6));

    }

    //语法格式六：当Lambda体只有一条语句时，return与大括号若有，都可以省略
    @Test
    public void test7(){

        Comparator<Integer> comparator1 = (o1, o2) -> {
          return o1.compareTo(o2);
        };

        System.out.println(comparator1.compare(12,6));

        System.out.println("****************");

        Comparator<Integer> comparator2 = (o1, o2) -> o1.compareTo(o2);

        System.out.println(comparator2.compare(12, 21));

    }

    @Test
    public void test8(){

        Consumer<String> consumer1 = s -> {
            System.out.println(s);
        };
        consumer1.accept("一个是听的人当真了，一个是说的人当真了");

        System.out.println("*******************************");

        Consumer<String> consumer2 = s -> System.out.println(s);

        consumer2.accept("一个是听的人当真了，一个是说的人当真了");
    }

}
