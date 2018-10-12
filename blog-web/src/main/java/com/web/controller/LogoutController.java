package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
