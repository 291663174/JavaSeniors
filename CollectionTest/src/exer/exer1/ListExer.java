package exer.exer1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wuhen
 * @Description
 * @date 2020-10-04 18:19
 **/
public class ListExer {
    @Test
    public void testListRemove(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);//
    }
    private static void updateList(List list){
        list.remove(2);
    }
}
