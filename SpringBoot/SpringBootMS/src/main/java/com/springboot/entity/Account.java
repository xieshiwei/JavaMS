package com.springboot.entity;

import java.io.Serializable;

/**
 * @ClassName Account
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2020/1/22 10:46
 **/
public class Account implements Serializable {

    private String name;
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
