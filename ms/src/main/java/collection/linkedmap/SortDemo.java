package collection.linkedmap;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class SortDemo {


    /**
     * 入口
     *
     * @param args
     */
    public static void main(String[] args) {

        //HashMap排序
        HashMap<String, String> hashMap = new HashMap<>();
        HashMapModel.sortHashMap(hashMap);

        //linkedHashMap排序
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        LinkedHashMapModel.sortLinkedHashMap(linkedHashMap);

        //accessOrder设置为true
        SetAccessOrder.setAccessOrder();
    }
}
