package com.api.controller;

import com.util.common.DateUtils;
import com.util.enums.ResultCodeEnum;
import com.util.common.Result;
import com.util.common.StringUtil;
import com.api.dao.UserMapper;
import com.api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "")
    public String login() {
        return "/login";
    }

    @RequestMapping(value = "/loginValidate")
    @ResponseBody
    public Result<User> loginValidate(User user, HttpServletRequest request) {
        Result<User> result = new Result<User>();

        String username = user.getUsername();
        String password = user.getPassword();
        if (StringUtil.isEmpty(username)) {
            result.setCode(ResultCodeEnum.CODE_002.getValue());
            result.setMsg("请输入用户名");
        }
        if (StringUtil.isEmpty(password)) {
            result.setCode(ResultCodeEnum.CODE_002.getValue());
            result.setMsg("请输入密码");
        }
        User data = userMapper.selectOne(user);
        //User data = userMapper.findByUsername(username);
        HttpSession session = request.getSession();
        session.setAttribute("user", data);
        if (data == null) {
            result.setCode(ResultCodeEnum.CODE_002.getValue());
            result.setMsg("用户名或密码错误");
        } else {
            data.setLastlogintime(DateUtils.getNowDateStr());
            userMapper.insertSelective(data);
            result.setCode(ResultCodeEnum.CODE_000.getValue());
            result.setMsg(ResultCodeEnum.CODE_000.getDescription());
            result.setData(data);
        }
        return result;
    }
}
