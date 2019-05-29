package thread.mysynchronized.demo4;

/**
 * @ClassName ThreadDirty
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2019/5/29 12:03
 **/
public class ThreadDirty extends Thread {

    /**
     * username
     */
    private String username = null;
    /**
     * password
     */
    private String password = null;

    /**
     * DirtyRead
     */
    private DirtyRead dirtyRead = null;

    /**
     * Constructor
     *
     * @param username
     * @param password
     * @param dirtyRead
     */
    public ThreadDirty(String username, String password, DirtyRead dirtyRead) {
        this.username = username;
        this.password = password;
        this.dirtyRead = dirtyRead;
    }

    @Override
    public void run() {

        this.dirtyRead.setValue(this.username, this.password);
    }
}
