package com.pendyliu.lesson18.service;

import com.pendyliu.lesson18.entity.Authority;
import com.pendyliu.lesson18.entity.User;
import com.pendyliu.lesson18.jpa.UserJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;

/**
 * ========================
 *
 * @CLASSNAME:PendyUserDetailService
 * @Description:
 * @Author DELL
 * @Date 2018/11/25 21:51
 * ========================
 */
@Component("userDetailsService")
public class PendyUserDetailService implements UserDetailsService {
    @Autowired
    UserJpa userJpa;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        String lowercaselogin = login.toLowerCase();
        User userFromDatabase = userJpa.findusernameCaseInsensitive(lowercaselogin);
        if (userFromDatabase == null) {
            throw new UsernameNotFoundException("User" + lowercaselogin + "was not found in the database");
        }
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Authority authority : userFromDatabase.getAuthorities()
                ) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getName());
            grantedAuthorities.add(grantedAuthority);
        }
        return new org.springframework.security.core.userdetails.User(
                userFromDatabase.getUsername(),
                userFromDatabase.getPassword(),
                grantedAuthorities);
    }
}
