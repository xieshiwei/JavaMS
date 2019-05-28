package collection.iteratortest;

import java.util.*;

public class iterator {

    /**
     * 测试删除元素在迭代器和集合中的区别
     *
     * @param args
     */
    public static void main(String[] args) {
        //删除list中的元素
        //removeByForeach();
        //删除迭代器中的元素
        removeByIterator();
    }

    /**
     * 删除迭代器Iterator中的元素
     */
    private static void removeByIterator() {
        ArrayList<String> arrayList = init();
        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if ("a".equals(item)) {
                System.out.println("----------------删除元素如下-----------------");
                System.out.println(item);
                iterator.remove();
            }
        }
        /**
         * 待确认
         * remove后直接遍历迭代器会报错，取不到next()里的数据，需要重新将集合赋值，
         * 可能每次迭代器操作完后会回收迭代器的数据。
         */
        iterator = arrayList.iterator();
        System.out.println("----------------删除后的结果如下-----------------");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * 在foreach中删除元素
     */
    private static void removeByForeach() {
        ArrayList<String> list = init();
        for (String item :
                list) {
            System.out.println(item);
            if ("a".equals(item)) {
                list.remove(item);
            }
        }
    }


    /**
     * 初始化
     *
     * @param list
     * @return
     */
    private static ArrayList<String> init() {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        System.out.println("----------------初始化结果如下-----------------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        return list;
    }
}
