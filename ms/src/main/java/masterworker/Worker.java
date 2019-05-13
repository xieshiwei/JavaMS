package masterworker;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker implements Runnable {

    //Worker队列
    private ConcurrentLinkedQueue<Task> workerQueue;
    //Worker处理结果集的队列
    private ConcurrentHashMap<String, Object> resultMap;

    /**
     * 设置Worker队列
     *
     * @param workerQueue
     */
    public void setWorkerQueue(ConcurrentLinkedQueue<Task> workerQueue) {

        this.workerQueue = workerQueue;
    }

    /**
     * 设置Worker处理结果
     *
     * @param resultMap
     */
    public void setResultMap(ConcurrentHashMap<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

    @Override
    public void run() {

        while (true) {
            //获取当前Worker并从队列中移除
            Task input = this.workerQueue.poll();
            if (input == null) {
                break;
            }

            Object output = handel(input);
            this.resultMap.put(Integer.toString(input.getId()), output);
        }

    }

    /**
     * 模拟处理的任务
     *
     * @param task
     * @return
     */
    private Object handel(Task task) {
        Object output = null;
        try {
            //表示任务的耗时
            Thread.sleep(500);
            output = task.getPrice();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return output;
    }
}
