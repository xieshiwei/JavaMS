package thread.countdownlatch;

import sun.security.ssl.Debug;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    private static final CountDownLatch latch = new CountDownLatch(2);
    private static final Random rnd = new Random();
    private static int data;

    public static void main(String[] args) throws InterruptedException {
        Thread workerThread = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i < 10; i++) {
                    data = i;
                    latch.countDown();
                    try {
                        Thread.sleep(rnd.nextInt(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        workerThread.start();
        latch.await();
        System.out.println("It's done. data=" + data);
        //Debug.println("It's done. data=%d", data);

    }
}
