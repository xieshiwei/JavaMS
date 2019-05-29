package thread.mysynchronized.demo5.syncdubbo2;

/**
 * @ClassName SubFun
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2019/5/29 13:48
 **/
public class SubFun extends MainFun {

    /**
     * 循环打印i直到i<=0
     */
    public void operationSub() {
        try {
            while (i > 0) {
                i--;
                System.out.println("Sub print i = " + i);
                Thread.sleep(100);
                this.operationMain();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
