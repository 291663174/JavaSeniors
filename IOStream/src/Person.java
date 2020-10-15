import java.io.Serializable;

/**
 * @author Wuhen
 * @Description Person需要满足如下的要求，方可序列化
 * 1.实现（标识接口）：Serializable
 * 2.当前类提供一个全局常量：serialVersionUID
 * 3.除了当前Person类需要实现Serializable接口之外，还必须保证其内部所有属性也必须是可序列化的
 *  （默认情况下，基本数据类型也是可序列化的）
 *  补充：ObjectOutputStream和ObjectInputStream不能序列化static和transient修饰的成员变量
 * 4.序列化机制：
 *  对象序列化机制允许把内存中的Java对象转换成平台无关的二进制流，从而允许把这种二进制流传输到
 *  另一个网络节点。当其他程序获取了这种二进制流，就可以恢复成原来的Java对象
 * @date 2020-10-10 17:08
 **/
public class Person implements Serializable {

    //需要识别序列版本号随便写一个数，Long型
    public static final long serialVersionUID = 495674674342L;

    private String name;
    private int age;
    private int id;
    private Account account;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public Person(String name, int age, int id, Account account) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                ", account=" + account +
                '}';
    }
}

class Account implements Serializable {

    //需要识别序列版本号随便写一个数，Long型
    public static final long serialVersionUID = 4956674342L;

    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}