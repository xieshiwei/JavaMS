package thread.mysynchronized.demo5.syncdubbo1;

/**
 * @ClassName SyncDubbo1
 * @Author 萌琪琪爸爸
 * @Description
 * 在使用Synchronize时，当一个线程得到一个对象锁后，再次请求此对象锁时是可以再次得到该对象的锁，
 * @Date 2019/5/29 13:21
 **/
public class SyncDubbo1 {

    /**
     * 调用method2
     * 打印
     */
    public synchronized void method1() {

        System.out.println("method1..threadname：" + Thread.currentThread().getName());
        method2();
    }

    /**
     * 调用method3
     * 打印
     */
    public synchronized void method2() {
        System.out.println("method2..threadname：" + Thread.currentThread().getName());
        method3();
    }

    /**
     * 打印
     */
    public synchronized void method3() {
        System.out.println("method3..threadname：" + Thread.currentThread().getName());
    }


    /**
     * main
     *
     * @param args
     */
    public static void main(String[] args) {

        SyncDubbo1 dubbo = new SyncDubbo1();
        ThreadSyncDubbo1 t1 = new ThreadSyncDubbo1(dubbo);
        ThreadSyncDubbo1 t2 = new ThreadSyncDubbo1(dubbo);
        t1.start();
        t2.start();
    }

}
