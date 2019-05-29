package thread.mysynchronized.demo2;

/**
 * @ClassName ThreadDemo1
 * @Author 萌琪琪爸爸
 * @Description 关键字synchronize取得的锁是对象锁，而不是把一段代码当做锁，
 * 所以代码中哪个线程先执行synchronize关键字的方法，哪个线程就持有该方法所属对象的锁（lock），
 * <p>
 * 在静态方法上加synchronize关键字，表示锁定.class类，类一级别的锁，独占class
 * @Date 2019/5/29 0:46
 **/
public class ThreadDemo2 {

    private int num = 0;
    private final String TAG = "a";

    /**
     * tag==a num=100 打印话术a
     * tag==b num=200 打印话术b
     *
     * @param tag
     */
    public void printNum(String tag) {
        try {
            if (TAG.equals(tag)) {
                num = 100;
                System.out.println("tag a, set num over!");
                Thread.sleep(1000);
            } else {
                num = 200;
                System.out.println("tag b, set num over!");
            }
            System.out.println("tag " + tag + ", num = " + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 输出
     */
    public static void print() {
        System.out.println("=================demo2=================");
        ThreadDemo2 d1 = new ThreadDemo2();
        ThreadDemo2 d2 = new ThreadDemo2();

        MultiThread t1 = new MultiThread(d1, "a");
        MultiThread t2 = new MultiThread(d2, "b");
        t1.start();
        t2.start();
    }
}
