import java.util.List;

/**
 * @author Wuhen
 * @Description DAO: data access object 数据访问对象
 *  表的共性操作的DAO
 * @date 2020-10-07 17:05
 **/
public class DAO<T> {

    //添加一条记录
    public void add(T t){

    }

    //删除一条记录
    public boolean remove(int index){
        return false;
    }

    //修改一条记录
    public void update(int index,T t){

    }

    //查询一条记录
    public T getIndex(int index){

        return null;
    }

    //查询多条记录
    public List<T> getForList(int index){

        return null;
    }

    //泛型方法：获取表中一共有多少条记录？  获取到long类型  获取最久的员工入职时间？ 获取到Date类型
    public <E> E getValue(){

        return null;
    }

}
