package masterworker;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Master {

    /**
     * 装载任务的集合
     */
    private ConcurrentLinkedQueue<Task> workQueue = new ConcurrentLinkedQueue<>();

    /**
     * 使用HashMap来装载Worker的集合
     */
    private HashMap<String, Thread> works = new HashMap<>();

    /**
     * 装载Worker结果集的集合
     */
    private ConcurrentHashMap<String, Object> resultMap = new ConcurrentHashMap<>();

    /**
     * 构造方法
     *
     * @param worker
     * @param workerCount
     */
    public Master(Worker worker, int workerCount) {

        //每一个worker对象都要有master的引用workQueue用于任务的领取，resultMap用于任务的提交
        worker.setWorkerQueue(this.workQueue);
        worker.setResultMap(this.resultMap);

        for (int i = 0; i < workerCount; i++) {
            //key是每个worker的名字，value表示线程执行对象
            works.put("子节点" + Integer.toString(i), new Thread(worker));
        }
    }

    /**
     * 提交方法
     *
     * @param task
     */
    public void submit(Task task) {
        this.workQueue.add(task);
    }

    /**
     * 启动一个应用程序，让所有的worker工作
     */
    public void execute() {
        for (Map.Entry<String, Thread> me : works.entrySet()) {
            me.getValue().start();
        }
    }

    /**
     * 判断所有Worker任务是否执行完成
     *
     * @return
     */
    public boolean isComplete() {
        for (Map.Entry<String, Thread> me : works.entrySet()) {
            if (me.getValue().getState() != Thread.State.TERMINATED) {
                return false;
            }
        }
        return true;
    }

    /**
     * 返回所有任务执行完的结果
     *
     * @return
     */
    public int getResult() {
        int resut = 0;
        for (Map.Entry<String, Object> me : resultMap.entrySet()) {
            //汇总的逻辑
            resut += (Integer) me.getValue();
        }
        return resut;
    }

}
