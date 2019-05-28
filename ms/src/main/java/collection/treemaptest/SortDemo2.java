package collection.treemaptest;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class SortDemo2 {
    /**
     * 长度
     */
    private final static int SIZE = 3;

    /**
     * 入口
     */
    public static void main(String[] args) {
        System.out.println("---------------- key 为 Sting 排序结果-----------------");
        String s = new String();
        createTreeMap(s);
        System.out.println("---------------- key 为 Long 排序结果-----------------");
        Long l = new Long(0);
        createTreeMap(l);
    }

    /**
     * 创建TreeMap重写Compare接口
     *
     * @param object
     */
    public static void createTreeMap(Object object) {
        TreeMap<Object, Object> treeMap = new TreeMap<>(new Comparator<Object>() {

            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String) {

                    /**
                     * 如果是字符串，按o1,o2的asc码的大小升序排序
                     */
                    return ((String) o1).compareTo((String) o2);
                } else if (o1 instanceof Long && o2 instanceof Long) {
                    /**
                     * 如果是数字，按数字大小升序排序
                     */
                    return ((Long) o1).compareTo((Long) o2);
                } else {
                    return 0;
                }
            }
        });

        /**
         * 添加数据
         */
//        for (int i = 1; i <= SIZE; i++) {
//
//            if (object instanceof String) {
//                /**
//                 * 字符串类型put字符串
//                 */
//                treeMap.put(String.valueOf(i), String.valueOf(i));
//            }
//            if (object instanceof Long) {
//                /**
//                 * 数字类型put数字
//                 */
//                treeMap.put(Long.valueOf(i), Long.valueOf(i));
//            }
//        }
        if (object instanceof String) {
            /**
             * 字符串类型put字符串
             */
            treeMap.put("ba", 4);
            treeMap.put("a", 5);
            treeMap.put("aa", 6);
        }
        if (object instanceof Long) {
            /**
             * 数字类型put数字
             */
            treeMap.put(1, 1);
            treeMap.put(2, 2);
            treeMap.put(3, 3);
        }
        print(treeMap);
    }

    /**
     * 打印结果
     *
     * @param map
     */
    public static void print(Map<Object, Object> map) {
        Iterator<Map.Entry<Object, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Object, Object> entry = it.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
