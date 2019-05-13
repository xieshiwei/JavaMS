package executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UseExecutors {
    public static void main(String[] args) {

        //创建了10个固定的线程
        ExecutorService pool = Executors.newFixedThreadPool(10);

        //executors.newScheduledThreadPool()
    }
}
