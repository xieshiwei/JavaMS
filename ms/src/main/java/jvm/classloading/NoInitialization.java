package jvm.classloading;

/**
 * 非主动使用类字段演示
 */
public class NoInitialization {
    public static void main(String[] args) {
        /**
         * 对于静态字段，只有直接定义这个字段的类才会被初始化，
         * 因此通过其子类来引用父类中定义的静态字段，只会触发父类的初始化而不会触发子类的初始化
         */
        //System.out.println(SubClass.value);

        //case 2
        //SuperClass[] sca = new SuperClass[10];

        /**
         * 在编译阶段通过常量传播优化，已经HELLOWORLD存储到了NotInitalization类的常量池中
         * 以后NotInitalization对常量ConstClass的引用被转化为NotInitalization类对自身常量池的引用
         * 没有ConstClass类的符号引用入口
         */
        System.out.println(CostClass.HELLOWORLD);

    }
}
