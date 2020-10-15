import org.junit.Test;

import java.io.*;

/**
 * @author Wuhen
 * @Description 对象流的使用
 * 1.ObjectInputStream 和 ObjectInputOutputStream
 * 2.作用：用于存储和读取基本数据类型数据或对象的处理流，它的强大之处就是可以把Java中的对象写入到数据源中，
 * 也能把对象bong数据源中还原回来。
 * 3.要想一个java对象是可序列化的，需要满足相应的要求，见Person.java
 * 4.序列化机制：
 * 对象序列化机制允许把内存中的Java对象转换成平台无关的二进制流传输到另一个网络节点。
 * 当其他程序获取了这种二进制流，就可以恢复成原来的Java对象。
 * @date 2020-10-10 16:40
 **/
public class ObjectInputOutputStreamTest {

    /**
     * 序列化过程：将内存中的java对象保存到磁盘中或通过网络传输出去
     * 使用ObjectInputOutputStream实现
     **/
    @Test
    public void testObjectOutputStream() {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("object.dat"));
            objectOutputStream.writeObject(new String("我爱北京天安门"));
            objectOutputStream.flush();

            objectOutputStream.writeObject(new Person("李四", 22, 1001, new Account(3000)));
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 反序列化：将磁盘文件中的对象还原为内存中的一个java对象
     * 使用objectInputStream来实现
     **/
    @Test
    public void testObjectInputStream() {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("object.dat"));
            Object object = objectInputStream.readObject();
            String str = (String) object;

            Person person = (Person) objectInputStream.readObject();
            System.out.println(person);

            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}