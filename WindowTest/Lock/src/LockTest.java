import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Wuhen
 * @Description 解决线程安全问题的方式三：Lock锁 ---- JDK5.0新增
 * 1.面试题：synchronized 与lock的异同？
 * 相同：二者都可以解决线程安全问题
 * 不同：synchronized机制在执行完相应的同步代码以后，自动的释放同步监视器
 *      lock需要手动的启动同步（Lock()）,同时结束同步也需要手动的实现（unlock()）
 *  2.优先使用顺序：
 *      lock -> 同步代码块（已经进入了方法体，分配了相应资源） -> 同步方法（在方法体之外）
 *  面试题：如果解决线程安全问题？有几种方式
 * @date 2020-09-18 10:46
 **/
public class LockTest {
    public static void main(String[] args) {
        Window window = new Window();

        Thread thread1 = new Thread();
        Thread thread2 = new Thread();
        Thread thread3 = new Thread();

        thread1.setName("窗口一");
        thread2.setName("窗口二");
        thread3.setName("窗口三");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Window implements Runnable {

    private int tickets = 100;

    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                //2.调用锁定方法lock()
                lock.lock();
                if (tickets > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":售票，票号为：" + tickets);
                    tickets--;
                } else {
                    break;
                }
            } finally {
                //3.调用解锁的方法
                lock.unlock();
            }
        }
    }
}
