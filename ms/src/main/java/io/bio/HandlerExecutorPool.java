package io.bio;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class HandlerExecutorPool {

    /**
     * 执行
     */
    private ExecutorService executor;

    /**
     * 创建线程池
     *
     * @param maxPoolSize
     * @param queueSize
     */
    public HandlerExecutorPool(int maxPoolSize, int queueSize) {
        this.executor = new ThreadPoolExecutor(
                //返回可用处理器的Java虚拟机的数量，作为核心线程数
                Runtime.getRuntime().availableProcessors(),
                //最大线程数
                maxPoolSize,
                //线程空闲时间
                120L,
                //时间单位为秒
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(queueSize));
    }

    /**
     * 执行
     * @param task
     */
    public void executor(Runnable task) {
        this.executor.execute(task);
    }


}
