package com.ms.collection.list;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @ClassName MyList
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2019/12/7 18:03
 **/
public class MyList {

    public static void myArrayList() {

    }

    public static void myLinkedList() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.remove();
        linkedList.set(1, "1");
    }


    public static void main(String[] args) {
        myLinkedList();

    }
}
