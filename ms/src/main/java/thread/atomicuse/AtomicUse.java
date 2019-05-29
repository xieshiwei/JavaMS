package thread.atomicuse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName AtomicUse
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2019/5/29 18:38
 **/
public class AtomicUse {

    private static AtomicInteger count = new AtomicInteger(0);

    public synchronized int multiAdd() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count.addAndGet(1);
        count.addAndGet(2);
        count.addAndGet(3);
        count.addAndGet(4);
        return count.get();
    }

    public static void main(String[] args) {
        final AtomicUse atomicUse = new AtomicUse();
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(atomicUse.multiAdd());
                }
            }));
        }
        for (Thread t : list) {
            t.start();
        }
    }

}
