package com.pendyliu.lesson18.controler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ========================
 *
 * @CLASSNAME:SecureController
 * @Description:
 * @Author DELL
 * @Date 2018/11/25 21:47
 * ========================
 */
@RestController
@RequestMapping("/secure")
public class SecureController {
    @RequestMapping(method = RequestMethod.GET)
    public String sayHello() {
        return "Hello secureUser";
    }
}
