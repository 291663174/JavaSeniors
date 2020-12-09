class Consumer extends Thread {

    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
//        Thread.currentThread().getName()
        System.out.println(getName() + ":开始消费产品....");
        while (true) {

            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.consumerProduct();
        }
    }
}


class Producer extends Thread {

    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
//        Thread.currentThread().getName()
        System.out.println(getName() + ":开始生产产品....");
        while (true) {

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.productProduct();
        }
    }
}

class Clerk {

    private int productCount = 0;

    /**
     *  生产产品
     **/
    public synchronized void productProduct() {

        if (productCount < 20) {
            productCount++;
            System.out.println(Thread.currentThread().getName() + ":开始生产第" + productCount + "个产品");
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     *  消费产品
     **/
    public synchronized void consumerProduct() {
        if (productCount > 0) {
            System.out.println(Thread.currentThread().getName() + "：开始消费第" + productCount + "个产品");
            productCount--;

            notify();
        } else {
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

/**
 * @author Wuhen
 * @Description 线程通信的应用，经典例题，生产者/消费者问题
 * 生产者（Productor）将产品交给店员（Clerk）,而消费者（Customer）从店员处取走产品，
 * 店员一次只能持有固定数量的产品（比如20），如果生产者试图生产更多的产品，店员会叫生产者停一下，
 * 店员会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品。
 * <p>
 * 分析：1.是否是多线程问题？是，生产者线程，消费者线程
 * 2.是否有共享数据？是，店员（或产品）
 * 3.如何解决线程的安全问题？同步机制，有三种方法
 * 4.是否涉及到线程的通信？是
 * @date 2020-09-19 0:36
 **/
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer producer = new Producer(clerk);
        producer.setName("生产者1");

        Consumer consumer = new Consumer(clerk);
        consumer.setName("消费者1");

        producer.start();
        consumer.start();
    }
}