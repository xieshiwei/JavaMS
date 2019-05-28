package collection.linkedmap;

import java.util.Iterator;
import java.util.Map;

public class Common {

    /**
     * 排序
     * @param iterator
     */
    public static void sort(Iterator<Map.Entry<String, String>> iterator) {
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("key:" + key + ",value:" + value);
        }
    }
}
