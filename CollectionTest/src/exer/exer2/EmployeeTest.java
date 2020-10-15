package exer.exer2;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author Wuhen
 * @Description
 *  创建该类的5个对象，并把这些对象放入TreeSet集合中（下一章：TreeSet需使用泛型来定义）
 *  分别按以下两种方式对集合中的元素进行排序，并遍历输出
 *      1）使Employee实现Comparable接口，并按name排序
 *      2）创建TreeSet时传入Comparator对象，按生日日期的先后排序
 * @date 2020-10-06 12:18
 **/
public class EmployeeTest {

    //问题二：按生日日期的先后排序
    @Test
    public void test2(){

        TreeSet set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee){
                    Employee employee1 = (Employee) o1;
                    Employee employee2 = (Employee) o2;

                    MyDate birthday1 = employee1.getBirthday();
                    MyDate birthday2 = employee2.getBirthday();

                    //方式二：
                }
                throw new RuntimeException("传入的数据类型不一致!");
            }
        });

        Employee employee1 = new Employee("liudehua",55,new MyDate(1965,5,4));
        Employee employee2 = new Employee("zhangxueyou",52,new MyDate(1968,8,4));
        Employee employee3 = new Employee("guofucheng",51,new MyDate(1969,5,8));
        Employee employee4 = new Employee("liming",50,new MyDate(1970,6,20));
        Employee employee5 = new Employee("liangchaowei",48,new MyDate(1972,6,14));

        set.add(employee1);
        set.add(employee2);
        set.add(employee3);
        set.add(employee4);
        set.add(employee5);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //问题一：使用自然排序
    @Test
    public void test1(){
        TreeSet set = new TreeSet();

        Employee employee1 = new Employee("liudehua",55,new MyDate(1965,5,4));
        Employee employee2 = new Employee("zhangxueyou",52,new MyDate(1968,8,4));
        Employee employee3 = new Employee("guofucheng",51,new MyDate(1969,5,8));
        Employee employee4 = new Employee("liming",50,new MyDate(1970,6,20));
        Employee employee5 = new Employee("liangchaowei",48,new MyDate(1972,6,14));

        set.add(employee1);
        set.add(employee2);
        set.add(employee3);
        set.add(employee4);
        set.add(employee5);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
