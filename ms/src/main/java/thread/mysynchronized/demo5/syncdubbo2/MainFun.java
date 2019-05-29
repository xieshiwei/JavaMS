package thread.mysynchronized.demo5.syncdubbo2;

/**
 * @ClassName MainFun
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2019/5/29 13:48
 **/
public class MainFun {
    public int i = 10;

    /**
     * i--
     * 打印内容
     * 休眠100ms
     */
    public synchronized void operationMain() {
        try {
            i--;
            System.out.println("Main print i = " + i);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
