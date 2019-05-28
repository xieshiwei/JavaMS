package collection.treemaptest;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @ClassName SortDemo
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2019/5/27 16:25
 **/
public class SortDemo {

    /**
     * 入口
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("---------------- 默认 排序结果-----------------");
        createDefaultSortTreeMap();
        System.out.println("---------------- 自定义 排序结果-----------------");
        createDefinitionSortTreeMap();
    }

    /**
     * TreeMap 默认排序
     */
    private static void createDefaultSortTreeMap() {
        TreeMap<String, String> treeMap = new TreeMap<>();
        init(treeMap);
        print(treeMap);
    }

    /**
     * 自定义排序，需要实现Compartor接口重现compareTo方法
     */
    private static void createDefinitionSortTreeMap() {
        TreeMap<String, String> treeMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        init(treeMap);
        print(treeMap);
    }

    /**
     * map 初始化
     *
     * @param map
     */
    private static void init(Map<String, String> map) {
        map.put("c", "1");
        map.put("a", "1");
        map.put("bb", "1");
        map.put("d", "1");
    }

    /**
     * 输出
     *
     * @param map
     */
    private static void print(Map<String, String> map) {
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
