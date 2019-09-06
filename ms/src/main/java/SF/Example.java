package SF;

/**
 * @ClassName 支出下列程序运行的结果
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 9/5/2019 8:36 PM
 **/
public class Example {

    String str = new String("good");
    char[] ch = {'a', 'b', 'c'};

    public static void main(String[] args) {

        Example ex = new Example();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str + " and ");
        System.out.println(ex.ch);
    }

    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'g';
    }
}
