import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @author Wuhen
 * @Description 一、集合框架的概述
 *  1.集合、数组都是对多个数据进行存储操作的结构，简称为Java容器。
 *      说明：此时的存储，主要指的是内存层面的存储，不涉及到持久化的存储（.txt, .jpg, .avi,数据库中）
 *  2.数组在存储多个数据方面的特点：
 *      > 特点：一旦初始化以后，其长度就确定了。
 *      > 数组一旦定义好，其元素的类型也就确定了，我们也就只能操作指定类型的数据了，
 *          比如：String[] arr; int[] arr1;Object[] arr2;
 *  3.数组在存储多个数据方面的缺点：
 *      > 一旦初始化以后，其长度就不可修改。
 *      > 数组中提供的方法非常有限，对于添加，删除，插入数据等操作，非常不便，同时效率不高
 *      > 获取数组中实际元素的个数的需求，数组没有现成的属性或方法可用
 *      > 数组存储数据的特点：有序、可重复，对于无序、不可重复的需求，不能满足。
 * 二、集合框架
 *  1.Collection接口，单列集合，用来存储一个一个的对象
 *      List接口：存储有序的，可重复的数据。  “动态数组”
 *          ArrayList、LinkedList、Vector
 *      Set接口：存储无序的，不可重复的数据   高中讲的“集合”
 *          HashSet、LinkedHashSet、TreeSet
 *    Map接口：双列集合，用来存储一对（key,value）一对的数据   高中函数：y=f(x)
 *          HashMap、LinkedHashMap、TreeMap、Hashtable、Properties
 * @date 2020-10-01 15:46
 **/
public class CollectionTest {

    @Test
    public void test1(){
        Collection collection = new ArrayList();
        //add(Object e);  将元素添加到集合collection中
        collection.add("AA");
        collection.add("BB");
        collection.add(123);
        collection.add(new Date());
        //size();  //4   获取添加的元素的个数
        System.out.println(collection.size());

        //addAll(Collection collection)：将coll1集合中的元素添加到当前的集合中
        Collection collection1 = new ArrayList();
        collection1.add(456);
        collection1.add("cc");
        collection.addAll(collection1);

        //6
        System.out.println(collection.size());
        System.out.println(collection);

        //clear();清空集合元素
        System.out.println(collection.isEmpty());

        //isEmpty():判断当前集合是否为空
        System.out.println(collection.isEmpty());
    }
}
