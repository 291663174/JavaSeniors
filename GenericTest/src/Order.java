import java.util.ArrayList;
import java.util.List;

/**
 * @author Wuhen
 * @Description  自定义泛型类
 * @date 2020-10-07 16:16
 **/
public class Order<T> {

    String orederName;
    int orderId;

    //类的内部结构化就可以使用类的泛型
    T orderT;

    public Order(){
        //编译不通过报错
//        T[] arr = new T[];
          //
          T[] arr = (T[]) new Object[10];
    }

    public Order(String orederName,int orderId,T orderT){
        this.orederName = orederName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    //如下的3个方法都不是泛型方法
    public T getOrderT(){
        return orderT;
    }

    public void setOrderT(T orderT){
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orederName='" + orederName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }

    //静态方法中不能使用类的泛型，早于对象的创建导致编译不通过报错
//    public static void show(T orderT){
//        System.out.println(orderT);
//    }
      public void show(){
        //编译不通过报错
//        try {
//
//        }catch (T t){
//
//        }
      }

      //泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系
      //换句话说：泛型方法所属的类是不是泛型类都没有关系
    public <E> List<E> copyFromatArrayToList(E[] arr){
        ArrayList<E> arrayList = new ArrayList<>();
        for (E e : arr){
            arrayList.add(e);
        }
        return arrayList;
    }
}
