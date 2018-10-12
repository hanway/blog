package com.web.controller;

import com.util.common.DateUtils;
import com.api.dao.MessageMapper;
import com.api.dao.UserMapper;
import com.api.entity.Message;
import com.api.entity.User;
import com.api.entity.vo.MessageVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/main")
public class IndexController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private UserMapper userMapper;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @RequestMapping(value = "")
    public String index(Model model) throws ParseException {
        List<MessageVo> messageVoList = new ArrayList<MessageVo>();

        List<Message> messageList = messageMapper.selectAll();

        logger.info("IndexController>>>>---messageList.size:" + messageList.size());

        for (Message message : messageList) {
            int userid = message.getUserid();
            User user = userMapper.selectByPrimaryKey(userid);

            MessageVo messageVo = new MessageVo();
            messageVo.setContent(message.getContent());
            messageVo.setUsername(user.getNickname());
            messageVo.setId(message.getId());
            String createtime = message.getCreatetime();
            messageVo.setCreatetime(DateUtils.format(sdf.parse(createtime)));

            messageVoList.add(messageVo);
        }
        model.addAttribute("list", messageVoList);
        return "index";
    }
}
