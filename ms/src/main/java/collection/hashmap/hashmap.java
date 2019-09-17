package collection.hashmap;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @ClassName hashmap
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2019/5/22 17:45
 **/
public class hashmap {


    public static void main(String[] args) {


        //book的HashCode和HashCode二进制
        String name = "book";
        System.out.println("book的HashCode：" + name.hashCode());
        String binaryValue = Integer.toBinaryString(name.hashCode());
        System.out.println("book的二进制：" + binaryValue);
        //HashMap长度
        int hashMapCount = 15;
        long hashMapBinaryCount = Long.parseLong(Integer.toBinaryString(hashMapCount));
        System.out.println("HashMap长度：" + hashMapBinaryCount);
        //通过与运算符计算二进制下标
        //long binaryIndex = binaryValue & hashMapBinaryCount;
        //计算HashMap中对应的下标
        //long index = Long.parseLong(binaryIndex + "", 2);
        System.out.println("book在HashMap中的二进制下标：" + hashMapBinaryCount);
        //System.out.println("book在HashMap中的十进制下标：" + index);

        ArrayList<String> list = new ArrayList<>();

    }


}
