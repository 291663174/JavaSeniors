import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author Wuhen
 * @Description 集合元素的遍历操作，使用迭代器Iterator接口
 *  1 . 内部的方法：hasNext()和next()
 *  2 . 集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前。
 *  3 . 内部定义了remove(),可以在遍历的时候，删除集合中的元素。此方法不同于集合直接调用remove()
 * @date 2020-10-02 12:30
 **/
public class IteratorTest {

    @Test
    public void test1(){
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add(new String("Tom"));
        collection.add(false);
        collection.add(new Person("Jerry",20));

        Iterator iterator = collection.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2(){
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add(new String("Tom"));
        collection.add(false);
        collection.add(new Person("Jerry",20));

        //错误方式一：NoSuchElementException报错
//        Iterator iterator = collection.iterator();
//        while (iterator.next() != null){
//            System.out.println(iterator.next());
//        }

        //错误方法二：死循环
//        while(collection.iterator().hasNext()){
//            System.out.println(collection.iterator().next());
//        }
    }

    /**
     *  测试Iterator中的remove()
     *  如果还未调用next()或在上一次调用next方法之后已经调用了remove方法
     *  再调用remove都会报IllegalStateException
     **/
    @Test
    public void test3(){
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add(new String("Tom"));
        collection.add(false);
        collection.add(new Person("Jerry",20));

        //删除集合中“Tom”
        Iterator iterator = collection.iterator();
        while(iterator.hasNext()){
            Object object = iterator.next();
            if ("Tom".equals(object)){
                iterator.remove();
            }
        }

        //重新指向首位，遍历集合
        iterator = collection.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

}
