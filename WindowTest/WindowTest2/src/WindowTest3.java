/**
 * @author Wuhen
 * @Description 使用同步代码块解决Thread类的方式的线程安全问题
 * 创建三个窗口卖票，总票数为100张,使用继承Thread类的方式
 *  说明：在继承Thread类的创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类充当同步监视器
 * @date 2020-09-17 22:44
 **/
public class WindowTest3 {
    public static void main(String[] args) {
        Window3 window3 = new Window3();

        Thread thread1 = new Thread(window3);
        Thread thread2 = new Thread(window3);
        Thread thread3 = new Thread(window3);

        thread1.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Window3 implements Runnable {

    private static int tickets = 100;

    //private static Object object = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (Window3.class) {
                if (tickets > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + tickets);
                    tickets--;
                } else {
                    break;
                }
            }
        }
    }
}
