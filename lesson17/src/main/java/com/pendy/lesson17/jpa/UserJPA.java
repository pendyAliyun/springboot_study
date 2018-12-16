package com.pendy.lesson17.jpa;

import com.pendy.lesson17.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * ========================
 *
 * @CLASSNAME:UserJPA
 * @Description:
 * @Author DELL
 * @Date 2018/9/16 19:20
 * ========================
 */
public interface UserJPA extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);
}
