package thread.mysynchronized.Demo1;

/**
 * @ClassName ThreadDemo1
 * @Author 萌琪琪爸爸
 * @Description 线程安全的概念，当多个线程访问某一个类，对象，方法时，这个对象始终能表现出正确的行为，那么这个类，对象，方法就是线程安全的。
 * synchronize：可以在任意对象方法上加锁，而加锁的这段代码称为互斥区
 * @Date 2019/5/29 0:29
 **/
public class ThreadDemo1 extends Thread {

    /**
     * 计数器
     */
    private int count = 5;

    @Override
    public synchronized void run() {
        count--;
        System.out.println(this.currentThread().getName() + " count = " + count);
    }

    /**
     * 当多个线程访问Demo1的Run方法时，以排队的方式进行处理（这里是按CPU分配的先后顺序而定的）
     * 一个线程想要执行Synchronized修饰的方法代码时，需要做到以下步骤：
     * 1 尝试活得锁
     * 2 如果拿到锁，执行synchronize代码体的内容
     * 3 如果拿不到锁，线程不断尝试获得这把锁，直到拿到为止
     */
    public static void print() {
        System.out.println("=================Demo1=================");
        ThreadDemo1 thread = new ThreadDemo1();
        Thread t1 = new Thread(thread, "t1");
        Thread t2 = new Thread(thread, "t2");
        Thread t3 = new Thread(thread, "t3");
        Thread t4 = new Thread(thread, "t4");
        Thread t5 = new Thread(thread, "t5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
