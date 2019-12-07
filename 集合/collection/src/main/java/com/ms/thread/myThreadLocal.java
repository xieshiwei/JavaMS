package com.ms.thread;

/**
 * @ClassName myThreadLocal
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2019/12/7 20:33
 **/
public class myThreadLocal {


    public static ThreadLocal threadLocal = new ThreadLocal();

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                threadLocal.set("1");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                threadLocal.set("2");
            }
        });

        t1.start();
        Thread.sleep(1000);
        t2.start();
    }

}
