/**
 * @author Wuhen
 * @Description 使用同步方法处理继承Thread类的方式中的线程安全问题
 * @date 2020-09-17 23:29
 **/
public class WindowTest5{
    public static void main(String[] args) {
        Window5 window1 = new Window5();
        Window5 window2 = new Window5();
        Window5 window3 = new Window5();

        window1.setName("窗口1");
        window2.setName("窗口2");
        window3.setName("窗口3");

        window1.start();
        window2.start();
        window3.start();
    }
}

class Window5  extends Thread {

    private static int tickets = 100;

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    /**
     *  private synchronized void show()
     *  同步监视器 window1,window2,window3
     **/
    //同步监视器Window5.class
    private static synchronized void show(){
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
