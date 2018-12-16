package com.pendy.lesson17;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * ========================
 *
 * @CLASSNAME:MVCConfig
 * @Description:
 * @Author DELL
 * @Date 2018/9/16 19:55
 * ========================
 */
@Configuration
public class MVCConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login2");
        registry.addViewController("/main").setViewName("main");
    }
}
