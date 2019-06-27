package thread;

/**
 * @ClassName WelcomeApp
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 6/27/2019 11:23 PM
 **/
public class WelcomeApp {

    public static void main(String[] args) {
        Thread t = new WelcomeThread();
        t.start();
        System.out.println("1.welcome! i'm %s.%n " + Thread.currentThread().getName());
    }
}

class WelcomeThread extends Thread {

    @Override
    public void run() {
        System.out.println("2.welcome! i'm %s.%n " + Thread.currentThread().getName());
    }
}
