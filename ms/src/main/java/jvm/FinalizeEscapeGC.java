package jvm;

/**
 * 此代码演示了两点：
 * 1 对象可以被GC时自我救赎
 * 2 这种自救的机会只有一次，因为一个对象的finalize()方法最多只会被系统自动调用一次
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("yes, i am still alive");
    }


    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) {
        SAVE_HOOK = new FinalizeEscapeGC();

        gcOperation();
        gcOperation();


    }

    private static void gcOperation() {
        //对象第一次成功救赎自己
        SAVE_HOOK = null;
        System.gc();

        try {
            //因为finalize方法优先级低，所以暂停0.5秒以等待它
            Thread.sleep(500);
        } catch (Exception exp) {
            exp.printStackTrace();

        }

        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead");
        }
    }
}
