/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbr.testhibernate.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author brazhnik
 */
@Entity
@Table(name = "Users", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"})})

public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, length = 11)
    private Long id;
    @Column(name = "login", nullable = false, unique = true, length = 50)
    private String login;
    @Column(name = "name", nullable = true, unique = false, length = 50)
    private String name;
    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;
    @Column(name = "loginType", nullable = false, unique = false, length = 10)
    private String loginType;

    /*1-email; 2-facebook; 3-google; 4-vk */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

}
