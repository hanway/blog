package com.api.dao;

import com.api.entity.Message;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface MessageMapper extends Mapper<Message> {
}
