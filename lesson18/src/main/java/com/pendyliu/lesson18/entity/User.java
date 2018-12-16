package com.pendyliu.lesson18.entity;

import org.hibernate.validator.constraints.Email;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * ========================
 *
 * @CLASSNAME:user
 * @Description:
 * @Author DELL
 * @Date 2018/11/25 20:52
 * ========================
 */
@Entity
public class User {

    @Id
    @Column(updatable = false, nullable = false)
    @Size(min = 0, max = 50)
    private String username;
    @Size(min = 0, max = 50)
    private String password;

    @Email
    @Size(min = 0, max = 50)
    private String email;

    private Boolean activated;

    @Column(name = "activationkey")
    @Size(min = 0, max = 100)
    private String activationKey;

    @Column(name = "resetpasswordkey")
    @Size(min = 0, max = 100)
    private String resetpasswordKey;

    @ManyToMany
    @JoinTable(name = "user_authority",joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "authority"))
    private Set<Authority> authorities;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public String getActivationKey() {
        return activationKey;
    }

    public void setActivationKey(String activationKey) {
        this.activationKey = activationKey;
    }

    public String getResetpasswordKey() {
        return resetpasswordKey;
    }

    public void setResetpasswordKey(String resetpasswordKey) {
        this.resetpasswordKey = resetpasswordKey;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }
}
