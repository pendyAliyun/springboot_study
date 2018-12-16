package com.pendyliu.lesson18.controler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ========================
 *
 * @CLASSNAME:HelloWorld
 * @Description:
 * @Author DELL
 * @Date 2018/11/25 21:44
 * ========================
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloWorldController {

    @RequestMapping(method = RequestMethod.GET)
    public String sayHello(){
        return "Hello User";
    }

}
