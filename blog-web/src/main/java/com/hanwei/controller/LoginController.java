package com.hanwei.controller;

import com.hanwei.common.StringUtil;
import com.hanwei.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @RequestMapping(value = "")
    public String login() {
        return "/login/login";
    }

    @RequestMapping(value = "/loginValidate")
    public String loginValidate(User user, HttpServletRequest request) {
        String username = user.getUsername();
        String password = user.getPassword();
        if (StringUtil.isEmpty(username)) {

        }
        return "";
    }
}
