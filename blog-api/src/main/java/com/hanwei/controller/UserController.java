package com.hanwei.controller;

import com.hanwei.dao.UserMapper;
import com.hanwei.entity.User;
import com.hanwei.common.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/getDate")
    public String getDate() {
        return DateUtils.getNowDateStr();
    }

    @RequestMapping(value = "/findAll")
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @RequestMapping(value = "/findByUsername")
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
