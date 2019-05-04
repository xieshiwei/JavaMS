package ThreadMS;

/**
 * @ClassName MyInnerSingleton
 * @Author 萌琪琪爸爸
 * @Description 单例
 * @Date 2019/4/29 14:14
 **/
public class MyInnerSingleton {

    /***
     * @Author 萌琪琪爸爸
     * @Description //TODO
     * @Date 2019/4/29 16:37
     * @Param
     * @return
     **/
    private static class Singletion {
        private static Singletion singletion = new Singletion();
    }

    /**
     * @return ThreadMS.MyInnerSingleton.Singletion
     * @Author 萌琪琪爸爸
     * @Description //TODO
     * @Date 2019/4/29 16:27
     * @Param []
     **/
    public static Singletion getInstance() {
        return Singletion.singletion;
    }

    /***
     * @Author 萌琪琪爸爸
     * @Description //TODO
     * @Date 2019/4/29 16:38
     * @Param [args]
     * @return void
     **/
    public static void main(String[] args) {
        Singletion singletion = MyInnerSingleton.getInstance();
    }
}
