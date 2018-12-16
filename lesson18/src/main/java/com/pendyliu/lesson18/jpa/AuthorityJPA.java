package com.pendyliu.lesson18.jpa;

import com.pendyliu.lesson18.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityJPA extends JpaRepository<Authority,String> {

}
