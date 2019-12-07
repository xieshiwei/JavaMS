package com.neo.controller;

import com.neo.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName HelloWorldController
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2019/12/6 20:46
 **/

@Controller
public class HelloWorldController {


    @Autowired
    Person person;

    @ResponseBody
    @RequestMapping("/hello")
    public static String sayHello() {
        return "hello";
    }
}
