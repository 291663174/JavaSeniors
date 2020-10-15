import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author Wuhen
 * @Description 向Collection接口的实现类的对象中添加数据obj时，要求Obj所在类要重写equals()
 * @date 2020-10-01 20:09
 **/
public class CollectionTest {
    @Test
    public void test1(){
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add(new String("Tom"));
        collection.add(false);
        collection.add(new Person("Jerry",20));

        //1 . contains(Object obj):判断当前集合中是否包含obj
        //我们在判断时会调用obj对象所在类的equals()
        boolean contains = collection.contains(123);
        System.out.println(contains);
        System.out.println(collection.contains(new String("Tom")));

        System.out.println(collection.contains(new Person("Jerry",20)));

        //2 . containsAll(Collection collection):判断形参collection中的所有元素是否都存在于当前集合中
        Collection collection1 = Arrays.asList(123,456);
        System.out.println(collection.containsAll(collection1));
    }

    @Test
    public void test2(){

        //3.remove(Object obj)
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add(new String("Tom"));
        collection.add(false);
        collection.add(new Person("Jerry",20));

        collection.remove(123);
        System.out.println(collection);

        collection.remove(new Person("Jerry",20));
        System.out.println(collection);

        //4.removeAll(Collection collection):差集：从当前集合中移除collection中所有的元素
        Collection collection1 = Arrays.asList(123,456);
        collection.removeAll(collection1);
        System.out.println(collection);

    }

    @Test
    public void test3(){
        //ArrayList是有序的，顺序不一样，内容不一样，也就是不一样的对象
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add(new String("Tom"));
        collection.add(false);
        collection.add(new Person("Jerry",20));

        //5 . retainAll(Collection collection):交集：获取当前集合和collection集合的交集，并返回给当前集合
//        Collection collection1 = Arrays.asList(123,456,789);
//        collection.retainAll(collection1);
//        System.out.println(collection);

        //6 . equals(Object obj):要想返回true,需要当前集合和形参集合的元素都相同
        Collection collection1 = new ArrayList();
        collection1.add(123);
        collection1.add(456);
        collection1.add(new String("Tom"));
        collection1.add(false);
        collection1.add(new Person("Jerry",20));
        System.out.println(collection.equals(collection1));
    }

    @Test
    public void test4(){
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add(new String("Tom"));
        collection.add(false);
        collection.add(new Person("Jerry",20));

        //7 . hashCode():返回当前对象的哈希值
        System.out.println(collection.hashCode());

        //8 . 集合转换为数组
        Object[] arrs = collection.toArray();
        for (int i = 0; i< arrs.length; i++){
            System.out.println(arrs[i]);
        }

        //拓展：数组转换为集合:调用Arrays类的静态方法asList()
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);

        List arr1 = Arrays.asList(new int[]{123,456});
        //1
        System.out.println(arr1.size());

        List arr2 = Arrays.asList(new Integer[]{123,456});
        //2
        System.out.println(arr2.size());

        //9 . iterator():返回Iterator接口的实例，用于遍历集合元素。放在IteratorTest,java中测试

    }

}
