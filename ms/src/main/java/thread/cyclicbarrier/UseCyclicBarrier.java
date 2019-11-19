package thread.cyclicbarrier;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 只有当指定的N个线程全都调用了await的时候，所有线程才会执行下去
 * CyclicBarrier使用场景：多台机器同时去执行同一个任务的时候
 *
 * 多个线程阻塞，只有全部线程调用了CyclicBarrier的await方法，所有阻塞线程继续执行
 */
public class UseCyclicBarrier {

    static class Runner implements Runnable {
        private CyclicBarrier barrier;
        private String name;

        public Runner(CyclicBarrier barrier, String name) {
            this.barrier = barrier;
            this.name = name;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000 * (new Random()).nextInt(5));
                System.out.println(name + " 准备OK. ");
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(name + " Go!! ");
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        //3个运动员
        CyclicBarrier barrier = new CyclicBarrier(3);
        //3个固定的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(new Thread(new Runner(barrier, "zhangsan")));
        executorService.submit(new Thread(new Runner(barrier, "lisi")));
        executorService.submit(new Thread(new Runner(barrier, "wangwu")));
        executorService.shutdown();
    }

}
