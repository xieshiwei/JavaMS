package Socket.bio2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName HandlerExecutorPool
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 11/19/2019 2:54 PM
 **/
public class HandlerExecutorPool {

    private ExecutorService executor;

    public HandlerExecutorPool(int maxPoolSize, int queueSize) {
        this.executor = new ThreadPoolExecutor(
                Runtime.getRuntime().availableProcessors(),
                maxPoolSize,
                120L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(queueSize));
    }

    public void execute(Runnable task) {
        this.executor.execute(task);
    }


}
