package thread;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName MyConcurrentMap
 * @Author 萌琪琪爸爸
 * @Description //ConcurrentHashMap
 * @Date 2019/4/29 16:51
 **/
public class MyConcurrentMap {


    public static void main(String[] args) {
        ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("k1", "v1");
        concurrentHashMap.put("k2", "v2");
        concurrentHashMap.put("k3", "v2");
        concurrentHashMap.putIfAbsent("k3", "vvvvv");
        for (Map.Entry<String, Object> me : concurrentHashMap.entrySet()) {
            System.out.println("key:" + me.getKey() + ",value" + me.getValue());
        }
    }

}
