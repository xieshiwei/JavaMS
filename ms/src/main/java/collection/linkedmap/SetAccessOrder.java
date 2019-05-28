package collection.linkedmap;


import java.util.*;

public class SetAccessOrder {

    public static void setAccessOrder() {
        //linkedHashMap构造
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>(
                16, 0.75f, true);
        LinkedHashMapModel.sortLinkedHashMap(linkedHashMap);

        System.out.println("通过get方法，导致key为name1对应的Entry到表尾");
        linkedHashMap.get("name1");
        LinkedHashMapModel.sortLinkedHashMap(linkedHashMap);
    }
}
