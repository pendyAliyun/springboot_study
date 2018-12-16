package com.pendy.lesson17.entity;

import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * ========================
 *
 * @CLASSNAME:RolesEntity
 * @Description:
 * @Author DELL
 * @Date 2018/9/16 18:55
 * ========================
 */

@Entity
@Table(name = "roles")
public class RoleEntity implements Serializable {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "r_id")
    private Long id;
    @Column(name = "r_name")
    private String name;

    @Column(name = "r_flag")
    private String flag;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
