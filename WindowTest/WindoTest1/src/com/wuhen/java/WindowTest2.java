package com.wuhen.java;

/**
 * @author Wuhen
 * @Description 例子：创建三个窗口卖票，总票数为100张.使用实现Runnable接口的方式
 *      存在线程的安全问题，待解决
 * @date 2020-09-17 18:50
 **/
public class WindowTest2 {
    public static void main(String[] args) {
        Window2 window2 = new Window2();

        Thread thread1 = new Thread(window2);
        Thread thread2 = new Thread(window2);
        Thread thread3 = new Thread(window2);

        thread1.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Window2 implements Runnable{

    private int tickets = 100;

    @Override
    public void run() {
        while (true){
            if(tickets > 0){
                System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + tickets);
                tickets--;
            }else {
                break;
            }
        }
    }
}