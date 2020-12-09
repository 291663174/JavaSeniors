package com.wuhen.java;
/**
 * @author Wuhen
 * @Description 多线程的创建
 * 方式一：继承Thread类
 * 1.创建一个继承于Thread类的子类
 * 2.重写Thread类的run()     将此线程执行的操作声明在run方法中
 * 3.创建Thread类的子类的对象
 * 4.通过此对象调用start()
 * 例子，遍历100以内的所有的偶数
 * @date 2020-09-15 12:12
 **/
class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class ThreadTest{
    public static void main(String[] args) {
        //3.创建Thread类的子类的对象
        MyThread myThread = new MyThread();
        //4.通过此对象调用start(); ① 启动当前线程 ② 调用当前线程的run()
        myThread.start();
        //问题一：我们不能通过直接调用run()方法启动线程
        //myThread.run();
        //问题二：再启动一个线程，遍历100以内偶数，不可以还让已经start()的线程取执行，会报异常IllegalThreadStateException()
        // 我们需要重新创建一个线程的对象  myThread.start();
        MyThread myThread2 = new MyThread();
        myThread2.start();

        //如下操作仍然是在main主线程中执行的
        for (int i = 0; i < 100; i++){
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i + "**************main()**************");
            }
        }

    }
}
