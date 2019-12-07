package com.neo;

import com.neo.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName SpringBootTest
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2019/12/6 21:52
 **/
@RunWith
@org.springframework.boot.test.context.SpringBootTest
public class SpringBootTest {

    @Autowired
    Person person;

    @Test
    public void contextLoads() {
        System.out.println(person);
    }


}
