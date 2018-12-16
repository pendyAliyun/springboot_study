package com.pendy.lesson17.controler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ========================
 *
 * @CLASSNAME:IndexController
 * @Description:
 * @Author DELL
 * @Date 2018/9/16 20:02
 * ========================
 */
@RestController
public class IndexController {
    @RequestMapping(value = "/index")
    public String index(){
        return "get index success!";
    }
}
