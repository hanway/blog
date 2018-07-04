package com.hanwei.controller;

import com.hanwei.common.Result;
import com.hanwei.common.StringUtil;
import com.hanwei.dao.UserMapper;
import com.hanwei.entity.User;
import com.hanwei.enums.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/logout")
public class LogoutController {

    @RequestMapping(value = "")
    public String login(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
