package com.hanwei.dao;

import com.hanwei.entity.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {

    List<User> findAll();

    User findByUsername(String username);
}
