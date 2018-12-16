package com.pendy.lesson17.service;

import com.pendy.lesson17.entity.UserEntity;
import com.pendy.lesson17.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * ========================
 *
 * @CLASSNAME:UserService
 * @Description:
 * @Author DELL
 * @Date 2018/9/16 19:27
 * ========================
 */
public class UserService implements UserDetailsService {
    @Autowired
    UserJPA userJPA;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userJPA.findByUsername(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException("未查到用户：" + username + "信息！");
        }
        return userEntity;
    }
}
