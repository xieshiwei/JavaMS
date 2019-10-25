package entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ClassName Dept
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 10/21/2019 3:23 PM
 **/
@NoArgsConstructor
@SuppressWarnings("serial")
@Data
@Accessors(chain = true)
public class Dept implements Serializable {

    /**
     * 住建
     */
    private Long deptno;
    /**
     * 部门名
     */
    private String dname;
    /**
     * 来自哪个数据库
     */
    private String db_source;

    public Dept(String dname) {
        super();
        this.dname = dname;
    }


}
