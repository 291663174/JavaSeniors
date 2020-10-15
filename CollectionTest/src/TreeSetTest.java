import org.junit.Test;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author Wuhen
 * @Description 1 . 向TreeSet中添加的数据，要求是相同类的对象。
 *              2.两种排序方式：自然排序和定制排序
 *              3.自然排序中，比较两个对象是否相同的标准为：compareTo()返回0，不再是equals()
 *              4.定制排序中，比较两个对象是否相同的标准为：compare()返回0，不再是equals()
 * @date 2020-10-05 20:28
 **/
public class TreeSetTest {
    @Test
    public void test1(){
        TreeSet set = new TreeSet();
        //举例一：
        //set.add(12);
        //set.add(-34);
        //set.add(65);
        //set.add(9);
        //举例二：
        set.add(new Person("Tom",12));
        set.add(new Person("Jerry",14));
        set.add(new Person("Tony",11));
        set.add(new Person("Jack",16));
        set.add(new Person("Jack",26));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
