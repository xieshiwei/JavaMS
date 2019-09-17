package collection.arraylist;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class TestArrayList {

    public static void main(String[] args) {

        ArrayList arrayList = new ArrayList();
        arrayList.add("aaaa");

        ArrayList a2 = (ArrayList) arrayList.clone();

    }
}
