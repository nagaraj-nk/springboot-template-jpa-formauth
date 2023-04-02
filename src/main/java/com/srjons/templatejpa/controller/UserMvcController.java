package com.srjons.templatejpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserMvcController {

    @GetMapping("/user_login")
    public String login(Model model) {
        return "loginPage";
    }

    @GetMapping("/login_success")
    public String loginSuccess(Model model) {
        return "loginSuccess";
    }

    @GetMapping("/login_failed")
    public String loginFailed(Model model) {
        return "loginFailed";
    }
}
