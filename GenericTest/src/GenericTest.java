import org.junit.Test;

import java.util.*;

/**
 * @author Wuhen
 * @Description
 *  泛型的使用
 *      1. jdk5.0新增的特性
 *      2.在集合中使用泛型：
 *          总结：①  集合接口或集合类在jdk5.0时都修改为带泛型的结构
 *               ②  在实例化集合类时：可以指明具体的泛型类型
 *               ③  指明完以后，在集合类或接口中凡是定义类或接口时，内部结构使用到类的泛型的位置，
 *                      都指定为实例化时泛型的类型。比如：add(E e) ---> 实例化以后可能是 add (Integer e)
 *               ④  注意点：泛型的类型必须是类，不能是基本数据类型。需要用到基本数据类型的位置，拿包装类替换
 *               ⑤  如果实例化时，没有指明泛型的类型，默认类型为java.lang.Object类型
 *   三、如何自定义泛型结构:泛型类、泛型接口、泛型方法、见GenericTest1.java
 * @date 2020-10-07 14:56
 **/
public class GenericTest {

    //在集合中使用泛型之前的情况：
    @Test
    public void test1(){
        ArrayList arrayList = new ArrayList();
        //需求：存放学生的成绩
        arrayList.add(78);
        arrayList.add(74);
        arrayList.add(92);
        arrayList.add(88);

        //问题一：类型不安全
        arrayList.add("Tom");

        for(Object score : arrayList){
            //问题二：强转时，可能出现CLassCastException
            int stuScore = (Integer) score;
            System.out.println(stuScore);
        }
    }

    //在集合中使用泛型的情况：
    @Test
    public void test2(){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(78);
        arrayList.add(74);
        arrayList.add(92);
        arrayList.add(88);
        //编译时就会进行类型检查，保证数据的安全
        //方式一：
//        for(Integer score : arrayList){
//            //避免了强制转换的操作
//            int stuScore = score;
//            System.out.println(stuScore);
//        }
        //方式二：
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            int stuScore = iterator.next();
            System.out.println(stuScore);
        }
    }

    //在集合中使用泛型的情况，以HashMap为例
    @Test
    public void test3(){
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("Tom",87 );
        map.put("Jerry",69 );
        map.put("Heck",73 );
        map.put("Amy",83 );

        //泛型的嵌套
        Set<Map.Entry<String,Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String,Integer>> iterator = entry.iterator();
        while (iterator.hasNext()){
            Map.Entry<String,Integer> entry1 = iterator.next();
            String key = entry1.getKey();
            Integer value = entry1.getValue();
            System.out.println(key + "----" + value);
        }

    }

}
