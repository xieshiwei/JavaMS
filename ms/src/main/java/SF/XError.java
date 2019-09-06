package SF;

/**
 * @ClassName XError
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 9/6/2019 11:03 AM
 **/
public class XError extends Thread implements Runnable {
    public void run() {
        System.out.println("this is run()");
    }

    public static void main(String[] args) {
        Thread t = new Thread(new XError());
        t.start();
    }
}
