package com.example.overwork.controller;

import com.example.overwork.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebmailController {
    private final LoginService loginService;

    public WebmailController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/webmail")
    public String webmail(Model model) {

        return "webmail";
    }
}
