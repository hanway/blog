package com.hanwei.controller;

import com.hanwei.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/logout")
public class LogoutController {

    Logger logger = LoggerFactory.getLogger(LogoutController.class);

    @RequestMapping(value = "")
    public String login(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
