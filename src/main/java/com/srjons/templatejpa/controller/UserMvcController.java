package com.srjons.templatejpa.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserMvcController {

    @GetMapping("/user_login")
    public String login(
            HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model) {
        return "loginPage";
    }
}
