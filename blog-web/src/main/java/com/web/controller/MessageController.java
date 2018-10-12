package com.web.controller;

import com.util.common.Result;
import com.util.common.StringUtil;
import com.api.dao.MessageMapper;
import com.api.entity.Message;
import com.api.entity.User;
import com.util.enums.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "/message")
public class MessageController {

    @Autowired
    private MessageMapper messageMapper;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @RequestMapping(value = "/addMessage")
    public String addMessage(Message message, HttpServletRequest request) {
        Result<Object> result = new Result<Object>();

        User user = (User) request.getSession().getAttribute("user");
        int userid = user.getId();

        String content = message.getContent();
        if (StringUtil.isEmpty(content)) {
            result.setCode(ResultCodeEnum.CODE_002.getValue());
            result.setMsg("内容为空");
        }
        message.setUserid(userid);
        message.setCreatetime(sdf.format(new Date()));

        messageMapper.insertSelective(message);
        result.setCode(ResultCodeEnum.CODE_000.getValue());
        result.setMsg(ResultCodeEnum.CODE_000.getDescription());
        return "redirect:/main";
    }
}
