package thread.threadlocal;


/**
 * ThreadLocal只在当前线程中可用，其他线程不可用
 * t1线程通过ThreadLocal赋值，并且成功获取ThreadLocal的值
 * t2线程无法取到t1线程给ThreadLocal赋的值
 */
public class MyThreadLocal {

    public ThreadLocal<String> th = new ThreadLocal<>();

    public void setTh(String value) {
        th.set(value);
    }

    public void getTh() {
        System.out.println(Thread.currentThread().getName() + ":" + this.th.get());
    }

    public static void main(String[] args) {

        final MyThreadLocal myThread = new MyThreadLocal();

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                myThread.setTh("张三");
                myThread.getTh();
            }
        };
        Thread t1 = new Thread(r1, "T1");

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    myThread.getTh();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t2 = new Thread(r2, "T2");

        t1.start();
        t2.start();
    }
}
