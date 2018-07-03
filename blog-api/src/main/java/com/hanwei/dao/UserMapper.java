package com.hanwei.dao;

import com.hanwei.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserMapper extends JpaRepository<User, Integer> {

    List<User> findAll();
}
