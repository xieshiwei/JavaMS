package io.nio;

import java.nio.IntBuffer;

/**
 * @ClassName TestBuffer
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2019/5/14 20:24
 **/
public class TestBuffer {

    public static void main(String[] args) {
        /**
         * Buffer基本操作
         */
        //baseOperation();

        /**
         * 通过wrap包装Buffer容器
         */
        //wrapOperation();

        /**
         * otherOperation
         */
        otherOperation();
    }

    /**
     * Buffer其他方法
     */
    private static void otherOperation() {
        IntBuffer buf1 = IntBuffer.allocate(10);
        int[] arr = new int[]{1, 2, 5};
        buf1.put(arr);
        System.out.println(buf1);

        /**
         * 一种复制方法
         */
        IntBuffer buf3 = buf1.duplicate();
        System.out.println(buf3);
        buf1.position(0);
        buf1.flip();
        System.out.println(buf1);

        /**
         * 可读数据
         */
        System.out.println("可读数据为：" + buf1.remaining());
        int[] arr2 = new int[buf1.remaining()];
        buf1.get(arr2);
        for (int i : arr2) {
            System.out.println(Integer.toString(i) + ",");

        }

    }

    /**
     * wrap方法
     * wrap方法会包裹一个数组，一般这种用法不会先初始化缓存对象的长度，
     * 因为没有意义，最后还会被wrap所包裹的数组覆盖掉。
     * 并且wrap方法修改缓冲区对象的时候，数组本身也会跟着发生变化。
     */
    private static void wrapOperation() {
        int[] arr = new int[]{1, 2, 5};
        IntBuffer buf1 = IntBuffer.wrap(arr);
        System.out.println(buf1);

        /**
         * 截取arr数组中下标从0开始的2位数据
         */
        IntBuffer buf2 = IntBuffer.wrap(arr, 0, 2);
        System.out.println(buf2);
    }

    /**
     * buffer的基本操作
     */
    private static void baseOperation() {

        IntBuffer buf = IntBuffer.allocate(10);
        //put后position 位置：0->1
        buf.put(13);
        //put后position 位置：1->2
        buf.put(21);
        //put后position 位置：2->3
        buf.put(35);
        //获取下标为1的元素
        System.out.println("获取指定下标的元素" + buf.get(1));
        buf.flip();
        System.out.println("使用flip复位：" + buf);
        //容量一旦初始化后不允许修改（warp方法包裹数组除外）
        System.out.println("容量为：" + buf.capacity());
        //可操作的元素上限为3
        System.out.println("限制为：" + buf.limit());
        //get(index)方法，position位置不改变
        System.out.println("get(index)方法，position位置不改变：" + buf);
        for (int i = 0; i < buf.limit(); i++) {
            //调用get方法会使其缓冲区位置（position）向后递增一位
            System.out.println(buf.get() + "\t");
        }
        System.out.println("buf对象遍历之后为: " + buf);
    }
}
