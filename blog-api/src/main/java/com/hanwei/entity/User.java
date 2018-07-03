package com.hanwei.entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    private Integer id;
    private String username;
    private String password;
    private String lastaccesstime;
    private String lastaccessip;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "lastaccesstime")
    public String getLastaccesstime() {
        return lastaccesstime;
    }

    public void setLastaccesstime(String lastaccesstime) {
        this.lastaccesstime = lastaccesstime;
    }

    @Column(name = "lastaccessip")
    public String getLastaccessip() {
        return lastaccessip;
    }

    public void setLastaccessip(String lastaccessip) {
        this.lastaccessip = lastaccessip;
    }
}
