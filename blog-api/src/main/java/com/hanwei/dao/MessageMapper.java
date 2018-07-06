package com.hanwei.dao;

import com.hanwei.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageMapper extends JpaRepository<Message, Integer> {
}
