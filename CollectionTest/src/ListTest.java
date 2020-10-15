import org.junit.Test;

import java.util.*;

/**
 * @author Wuhen
 * @Description
 *  1.list接口框架
 *     Collection接口，单列集合，用来存储一个一个的对象
 *       List接口：存储有序的，可重复的数据。  “动态数组”,替换原有的数组
 *           ArrayList：作为List接口的主要实现类。线程不安全的，效率高；底层使用Object[] elementData存储
 *           LinkedList：为了频繁的插入、删除操作，使用此类效率比ArrayList高，底层使用双向链表存储
 *           Vector：作为List接口的古老实现类；线程安全的，效率低；底层使用Object[] elementData存储
 *
 *  2.ArrayList的源码分析：
 *    2.1 jdk7情况下
 *      ArrayList list = new ArrayList(); // 底层创建了长度是10的Object[]数组elementData
 *      list.add(123);  //elementData[0] = 123   //elementData[0] = new Integer(123)
 *      ...
 *      list.add(11);   //如果此次的添加导致底层elementData数组容量不够，则扩容。
 *      默认情况下，扩容为原来的容量的1.5倍，同时需要将原有数组中的数组复制到新的数组中。
 *
 *      结论：建议开发中使用带参的构造器：ArrayList list = new ArrayList(int capacity);
 *
 *   2.2  jdk8中ArrayList的变化；
 *       ArrayList list = new ArrayList(); // 底层Object[] elementData初始化为{},并没有创建长度为10的数组
 *       list.add(123);  //第一次调用add()时,底层才创建了长度为10的数组，并将数据123添加到elementData[0]
 *       ...
 *       后续的添加和扩容操作和jdk7无异
 *   2.3  小结：jdk7中的ArrayList的创建类似于单例模式中的饿汉式，而jdk8中的ArrayList的创建类似于单例模式中的
 *              懒汉式，延迟了数组的创建，节省内存。
 *
 *   3.LinkedList的源码分析
 *      LinkedList list = new LinkedList();  //内部声明了Node类型的first和last属性，默认值为null
 *      list.add(123);  //将123封装到Node中，创建了Node对象
 *
 *      其中，Node定义为：
 *          private static class Node<E> {
 *              E item;
 *              Node<E> next;
 *              Node<E> prev;
 *
 *              Node(Node<E> prev, E element, Node<E> next) {
 *              this.item = element;
 *              this.next = next;
 *              this.prev = prev;
 *              }
 *          }
 *   4. Vector的源码分析：jdk7和jdk8中通过Vector（）构造器创建对象时，底层都创建了长度为10的数组
 *      在扩容方面，默认扩容为原来的数组长度的2倍
 *
 *  面试题：ArrayList、LinkedList、Vector三者的异同？
 *    同：三个类都是实现了List接口，存储数据的特点相同：存储有序的、可重复的数据
 *    不同：见上
 *
 *  5.List接口中的常用方法
 *
 * @date 2020-10-03 17:22
 **/
public class ListTest {

    /**
     *  void add(int index, Object ele): 在index 位置插入ele 元素
     *  boolean addAll(int index, Collection eles): 从index 位置开始将eles中的所有元素添加进来
     *  Object get(int index): 获取指定index 位置的元素
     *  int indexOf(Object obj): 返回obj 在集合中首次出现的位置
     *  int lastIndexOf(Object obj): 返回obj 在当前集合中末次出现的位置
     *  Object remove(int index): 移除指定index 位置的元素，并返回此元素
     *  Object set(int index, Object ele): 设置指定index 位置的元素为ele
     *  List subList(int fromIndex, int toIndex): 返回从fromIndex 到toIndex位置的子集合
     *  总结：常用方法
     *      增：add(Object obj)
     *      删：remove(int index) / remove(Object obj)
     *      改：set(int index,Object ele)
     *      查：get(int index)
     *      插：add(int index,Object ele)
     *      长度：size()
     *      遍历：① Iterator迭代器方式
     *           ② 增强for循环
     *           ③ 普通的循环
     **/
    @Test
    public void test3(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(123);
        arrayList.add(456);
        arrayList.add("AA");

        //方式一：Iterator迭代器方式
        Iterator iterator = arrayList.listIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        for (Object obj : arrayList){
            System.out.println(obj);
        }

        //方式三：普通for循环
        for (int i = 0; i < arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }

    }

    @Test
    public void test2(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(123);
        arrayList.add(456);
        arrayList.add("AA");
        arrayList.add(new Person("Tom",12));
        arrayList.add(456);

        //int indexOf(Object obj): 返回obj 在集合中首次出现的位置.如果不存在，返回-1
        int index = arrayList.indexOf(456);
        System.out.println(index);

        //int lastIndexOf(Object obj): 返回obj 在当前集合中末次出现的位置.如果不存在，返回-1
        System.out.println(arrayList.lastIndexOf(456));

        //Object remove(int index): 移除指定index 位置的元素，并返回此元素
        Object obj = arrayList.remove(0);
        System.out.println(obj);
        System.out.println(arrayList);

        //Object set(int index, Object ele): 设置指定index 位置的元素为ele
        arrayList.set(1, "CC");
        System.out.println(arrayList);

        //List subList(int fromIndex, int toIndex): 返回从fromIndex 到toIndex位置的左闭右开区间的子集合
        List list = arrayList.subList(2, 4);
        System.out.println(list);
        System.out.println(arrayList);

    }


    @Test
    public void test1(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(123);
        arrayList.add(456);
        arrayList.add("AA");
        arrayList.add(new Person("Tom",12));
        arrayList.add(456);

        System.out.println(arrayList);

        //void add(int index, Object ele): 在index 位置插入ele 元素
        arrayList.add(1,"BB");
        System.out.println(arrayList);

        //boolean addAll(int index, Collection eles): 从index 位置开始将eles中的所有元素添加进来
        List list = Arrays.asList(1, 2, 3);
        arrayList.addAll(list);
        //9
        System.out.println(arrayList.size());

        //Object get(int index): 获取指定index 位置的元素
        System.out.println(arrayList.get(0));

    }
}
