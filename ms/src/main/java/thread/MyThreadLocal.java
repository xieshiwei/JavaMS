package thread;


/**
 * ThreadLocal只在当前线程中可用，其他线程不可用
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
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                myThread.setTh("张三");
                myThread.getTh();
            }
        }, "T1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    myThread.getTh();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "T2");

        t1.start();
        t2.start();
    }
}
