import org.junit.Test;

import java.util.*;

/**
 * @author Wuhen
 * @Description
 * @date 2020-10-07 1:19
 **/
public class TreeMapTest {

    //向TreeMap中添加key-value,要求key必须是由同一个类创建的对象
    //因为要按照key进行排序：自然排序，定制排序
    //自然排序
    @Test
    public void test1(){
        TreeMap map = new TreeMap();
        Person person1 = new Person("Tom", 23);
        Person person2 = new Person("Jerry", 19);
        Person person3 = new Person("Rose", 18);
        Person person4 = new Person("Heck", 20);
        map.put(person1, 98);
        map.put(person2, 92);
        map.put(person3, 76);
        map.put(person4, 100);
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()){
            Object obj = iterator1.next();
            //entrySet集合中的元素都是entry
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "---->" + entry.getValue());
        }
    }

    //定制排序
    @Test
    public void test2(){
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person){
                    Person person1 = (Person) o1;
                    Person person2 = (Person) o2;
                    return Integer.compare(person1.getAge(), person2.getAge());
                }
                throw new RuntimeException("输入的类型不匹配！");
            }
        });
        Person person1 = new Person("Tom", 23);
        Person person2 = new Person("Jerry", 19);
        Person person3 = new Person("Rose", 18);
        Person person4 = new Person("Heck", 20);
        map.put(person1, 98);
        map.put(person2, 92);
        map.put(person3, 76);
        map.put(person4, 100);
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()){
            Object obj = iterator1.next();
            //entrySet集合中的元素都是entry
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "---->" + entry.getValue());
        }
    }

}
