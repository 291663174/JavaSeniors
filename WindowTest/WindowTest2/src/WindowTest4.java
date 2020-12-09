/**
 * @author Wuhen
 * @Description 使用同步方法解决实现Runnable接口的线程安全问题
 *  关于同步方法的总结：
 *      1.同步方法仍然设计到同步监视器，只是不需要我们显式的声明。
 *      2.非静态的同步方法，同步监视器是：this
 *          静态的同步方法，同步监视器是；当前类本身
 * @date 2020-09-17 23:13
 **/
public class WindowTest4 {
    public static void main(String[] args) {
        Window4 window4 = new Window4();

        Thread thread1 = new Thread(window4);
        Thread thread2 = new Thread(window4);
        Thread thread3 = new Thread(window4);

        thread1.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Window4 implements Runnable {

    private int tickets = 100;

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    /*
     *  同步监视器：this
     */
    private synchronized void show() {
        if (tickets > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + tickets);
            tickets--;
        }
    }
}