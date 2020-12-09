import org.junit.Test;

/**
 * @author Wuhen
 * @Description
 * @date 2020-09-20 17:05
 **/
public class StringTest {

    /**
     *  结论：
     *      1.常量与常量的拼接结果在常量池，且常量池中不会存在相同内容的常量。
     *      2.只要其中有一个是变量，结果就在堆中。
     *      3.如果拼接的结果调用intern()方法，返回值就在常量池中
     **/
    @Test
    public void test3(){
        String s1 = "javaEE";
        String s2 = "hadoop";
        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;

        //true
        System.out.println(s3 == s4);
        //false
        System.out.println(s3 == s5);
        //false
        System.out.println(s3 == s6);
        //false
        System.out.println(s5 == s6);
        //false
        System.out.println(s3 == s7);
        //false
        System.out.println(s5 == s7);
        //false
        System.out.println(s6 == s7);

        //返回值得到的s8使用的常量值中已经存在的“javaEEhadoop”
        String s8 = s5.intern();
        //true
        System.out.println(s3 == s8);
    }

    /**
     *  String的实例化方式
     *  方式一：通过字面量定义的方式
     *  方式二：通过new + 构造器的方式
     *
     *  面试题：String s = new String("abc");方式创建对象，连内存中创建了几个对象？
     *          两个：一个是堆空间中new结构，另一个是char[]对应的常量池中的数据：“abc”
     **/
    @Test
    public void test2(){
        //此时的s1和s2的数据javaEE声明在方法区中的字符串常量池中
        String s1 = "javaEE";
        String s2 = "javaEE";
        //通过new + 构造器的方式,此时的s3和s4保存的地址值，是数据在堆空间中开辟空间以后对应的地址值
        String s3 = new String("javaEE");
        String s4 = new String("javaEE");

        //true
        System.out.println(s1 == s2);
        //false
        System.out.println(s1 == s3);
        //false
        System.out.println(s1 == s4);
        //false
        System.out.println(s3 == s4);

        System.out.println("******************************");
        Person person1 = new Person("Tom",12);
        Person person2 = new Person("Tom",12);
        //true
        System.out.println(person1.name.equals(person2.name));
        System.out.println(person1.name == person2.name);
    }

    @Test
    public void test1() {

        /**
         *  1.String是定义为final的，不可被继承。
         *  2.String实现了Serializable接口，表示字符串是支持序列化的
         *          实现了Comparable接口，表示String可以比较大小
         *  3.String内部定义了final char[] value用于存储字符串数据
         *  4.String代表不可变的字符序列，简称：不可变性。
         *          体现：1.当对字符串重新赋值时，需要重写指定内存区域
         *               2.当对现有的字符串进行连接操作时，也需要重新指定内存区域赋值，不能在原有的value上赋值
         *               3.当调用String的replace()方法修改指定字符或者字符串时，也需要重新指定内存区域赋值
         *  5.通过字面量的方式（区别于new）给一个字符串赋值，此时的字符串值声明在字符串常量池中。
         *  6.字符串常量池中是不会存储相同内容的字符串的。
         **/
        //字面量的定义方式
        String s1 = "abc";
        String s2 = "abc";
        //s1 = "hello";
        //比较一下s1,s2的地址值
        System.out.println(s1 == s2);
        //hello
        System.out.println(s1);
        //abc
        System.out.println(s2);
        System.out.println("**********");

        String s3 = "abc";
        s3 += "def";
        //abcdef
        System.out.println(s3);

        String s4 = "abc";
        String s5 = s4.replace('a', 'm');
        //abc
        System.out.println(s4);
        //mbc
        System.out.println(s5);
    }

}
