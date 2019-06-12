package basic;

import java.awt.*;

/**
 * @ClassName Cat
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2019/6/4 7:22
 **/
public class Cat {
    private String name;
    private String color;

    public Cat(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
