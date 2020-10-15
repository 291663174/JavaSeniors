import org.junit.Test;

import javax.swing.ListModel;
import java.util.*;

/**
 * @author Wuhen
 * @Description
 *  1.泛型在继承方面的体现
 *      虽然类A是类B的父类，但是G<A>和G<B>二者不具有子父类关系，二者是并列关系
 *      补充：类A是类B的父类:A<G>  B<G>
 *  2.通配符的使用
 * @date 2020-10-07 17:19
 **/
public class GenericTest2 {

    /**
     *  1.泛型在继承方面的体现
     *      虽然类A是类B的父类，但是G<A>和G<B>二者不具备子父类关系，二者是并列关系
     *      补充：类A是类B的父亲，A<G>是B<G>的父类
     *  2.通配符的使用：
     **/
    @Test
    public void test1(){

        Object obj = null;
        String str = null;

        obj = str;

        Object[] objs = null;
        String[] strs = null;
        objs = strs;

        List<Object> list1 = null;
        List<String> list2 = new ArrayList<String>();
        //此时的list1和list2的类型不具有子父类关系
        //list1 = list2;
        //Date date = new Date();
        //str = date;
        /**
         *  反证法：假设list1 = list2;
         *             list1.add(123);导致混入非String的数据，出错
         **/
        show(list1);
        show1(list2);
    }

    public void show1(List<String> list){

    }

    public void show(List<Object> list){

    }

    @Test
    public void test2(){
        AbstractList<String> list1 = null;
        List<String> list2 = null;
        ArrayList<String> list3 = null;
        list1 = list3;
        list2 = list3;
        List<String> list4 = new ArrayList<>();
    }

    /**
     *  2.通配符的使用
     *      通配符：？
     *     类A是类B的父类：G<A>和G<B>是没有关系的，二者共同的父类是：G<?>
     **/
    @Test
    public void test3(){
        List<Object> list1 = null;
        List<String> list2 = null;
        List<?> list = null;
        list = list1;
        list = list2;
        //编译通过
//        print(list1);
//        print(list2);

        //
        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
        list = list3;

        //添加：对于List<?>就不能向其内部添加数据。
        //除了添加null之外
        //list.add("DD");
        //list.add(‘?’);
        list.add(null);

        //获取（读取）：允许读取数据，读取的数据类型为Object.
        Object obj = list.get(0);
        System.out.println(obj);

    }

    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }

    /**
     *  3.有限制条件的通配符的使用：
     *      ？ extends A:
     *           G<? extends A> 可以作为G<A>和G<B>的父类的，其中B是A的子类
     *           
     **/
    @Test
    public void test4(){

    }
}
