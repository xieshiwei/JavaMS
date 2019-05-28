package collection.linkedmap;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapModel {

    /**
     * LinkedHashMap排序
     * 当我们希望有顺序地去存储key-value时，就需要使用LinkedHashMap了。
     * LinkedHashMap是有序的，且默认为插入顺序。
     */
    public static void sortLinkedHashMap(LinkedHashMap<String, String> linkedHashMap) {
        if (linkedHashMap == null || linkedHashMap.isEmpty()) {
            linkedHashMap = init(linkedHashMap);
        }
        Iterator<Map.Entry<String, String>> iterator = linkedHashMap.entrySet().iterator();
        System.out.println("---------------- linkedHashMap 排序结果 -----------------");
        Common.sort(iterator);
    }

    public static LinkedHashMap<String, String> init(LinkedHashMap<String, String> linkedHashMap) {
        linkedHashMap.put("name1", "josan1");
        linkedHashMap.put("name2", "josan2");
        linkedHashMap.put("name3", "josan3");
        return linkedHashMap;
    }
}
