package com.spring.model;

import java.io.Serializable;

/**
 * @ClassName AccountDao
 *
 * 用户尸体类
 *
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2019/12/28 19:25
 **/
public class Account implements Serializable {

    private Integer id;
    private String name;
    private Float money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
