/**
 * @author Wuhen
 * @Description 使用同步机制将单例模式中的懒汉式改写为线程安全的
 * @date 2020-09-17 23:55
 **/
public class BankTest {

}

class Bank {

    private Bank() {
    }

    private static Bank instance = null;

    /**
     * 方式一：效率稍差  同步监视器 Bank.class
     * public static synchronized Bank getInstance(){}
     **/
    public static Bank getInstance() {
       /*
         synchronized (Bank.class) {
            if (instance == null) {
                instance = new Bank();
            }
            return instance;
         }
        */
        //方式二  效率更高
        if (instance == null){
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}
