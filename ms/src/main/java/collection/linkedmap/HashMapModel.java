package collection.linkedmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapModel {
    /**
     * Hashmap 排序
     * HashMap是无序的
     */
    public static void sortHashMap(HashMap<String, String> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            hashMap = init(hashMap);
        }
        Iterator<Map.Entry<String, String>> iterator = hashMap.entrySet().iterator();
        System.out.println("---------------- HashMap 排序结果 -----------------");
        Common.sort(iterator);
    }

    /**
     * HashMap初始化
     *
     * @param hashMap
     * @return
     */
    public static HashMap<String, String> init(HashMap<String, String> hashMap) {
        hashMap.put("name1", "josan1");
        hashMap.put("name2", "josan2");
        hashMap.put("name3", "josan3");
        return hashMap;
    }
}
