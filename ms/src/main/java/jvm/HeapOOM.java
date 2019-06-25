package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName HeapOOM
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 6/20/2019 3:51 PM
 **/
public class HeapOOM {

    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }
    }

}
