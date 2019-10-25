package com.mengqiqi.entitis;

import java.io.Serializable;

/**
 * @ClassName User
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 10/22/2019 12:57 PM
 **/
public class User implements Serializable {

    private int deptno;
    private String dname;
    private String db_source;

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDb_source() {
        return db_source;
    }

    public void setDb_source(String db_source) {
        this.db_source = db_source;
    }

    @Override
    public String toString() {
        return "User{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", db_source='" + db_source + '\'' +
                '}';
    }
}
