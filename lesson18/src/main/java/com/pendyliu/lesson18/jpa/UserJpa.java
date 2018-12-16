package com.pendyliu.lesson18.jpa;

import com.pendyliu.lesson18.entity.User;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * ========================
 *
 * @CLASSNAME:UserJpa
 * @Description:
 * @Author DELL
 * @Date 2018/11/25 21:33
 * ========================
 */
public interface UserJpa extends JpaRepository<User, String> {
    @Query("SELECT u from User u where lower(u.username)=lower(:username)")
    User findusernameCaseInsensitive(@Param("username") String username);
}
