import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Wuhen
 * @Description jdk5.0新增了foreach循环，用于遍历集合，数组
 * @date 2020-10-03 0:28
 **/
public class ForTest {
    @Test
    public void test1() {
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add(new String("Tom"));
        collection.add(false);
        collection.add(new Person("Jerry", 20));

        //for(集合元素的类型  局部变量 ： 集合对象)
        //内部仍然调用了迭代器
        for(Object obj : collection){
            System.out.println(obj);
        }
    }

    @Test
    public void test2(){
        int[] arr = new int[]{1,2,3,4,5};
        //for(数组元素的类型  局部变量 ： 数组对象)
        for (int i : arr){
            System.out.println(i);
        }
    }

    @Test
    public void test3(){

        String[] arr = new String[]{"MM","MM","MM"};

        //方式一：普通for循环赋值
//        for (int i = 0; i < arr.length; i++){
//            arr[i] = "GG";
//        }

        //方式二：增强for循环,重新给s赋值，修改s不会对数组造成影响，不同于方法一
        for (String str : arr){
            str = "GG";
        }

        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
