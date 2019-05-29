package thread.mysynchronized.demo4;

/**
 * @ClassName DirtyRead
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2019/5/29 11:30
 **/
public class DirtyRead {

    /**
     * username
     */
    private String username = "xsw";
    /**
     * password
     */
    private String password = "830210";


    /**
     * 给 username password 赋值
     *
     * @param username
     * @param password
     */
    public synchronized void setValue(String username, String password) {

        try {
            Thread.sleep(2000);
            this.username = username;
            this.password = password;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("setValue最终结果：username = " + username + " , password = " + password);
    }

    /**
     * 获取打印 username password
     */
    public synchronized void getValue() {
        System.out.println("getValue方法得到：username = " + this.username + " , password = " + this.password);
    }

    /**
     * 打印输出结果
     */
    public static void print() {
        DirtyRead dirtyRead = new DirtyRead();
        ThreadDirty t1 = new ThreadDirty("ly", "840509", dirtyRead);
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dirtyRead.getValue();
    }
}
