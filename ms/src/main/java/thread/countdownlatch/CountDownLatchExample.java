package thread.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;


/**
 * CountDownLatch
 * 经常用于监听某些初始化操作，等初始化执行完后，通知主线程继续工作
 * 场景
 * 比如在创建zkclient实例后，马上调用zk的API方法，但实际ZKclient还没有链接成功，这个时候调用方法会报错
 * 此时可以通过CountDownLatch来监控zk的实例
 *
 * 一个线程等待，N个线程给他发出通知，然后那一个线程继续执行，一个await()等待，多个countDown-锁存起的数量
 *
 */
public class CountDownLatchExample {
    public static void main(String[] args) {
        final CountDownLatch countDown = new CountDownLatch(2);
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("进入线程t1" + "等待其他线程处理完成...");
                    countDown.await();
                    System.out.println("t1线程继续执行...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t1 = new Thread(runnable1, "t1");

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("t2进行初始化操作");
                    Thread.sleep(3000);
                    System.out.println("t2线程初始化完毕，通知t1线程继续执行...");
                    //减少锁存器的计数器，技术达到0，释放所有等待线程
                    countDown.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t2 = new Thread(runnable2, "t2");
        Runnable runnable3 = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("t3进行初始化操作");
                    Thread.sleep(4000);
                    System.out.println("t3线程初始化完毕，通知t1线程继续执行...");
                    //减少锁存器的计数器，技术达到0，释放所有等待线程
                    countDown.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t3 = new Thread(runnable3, "t3");
        t1.start();
        t2.start();
        t3.start();
    }

}
