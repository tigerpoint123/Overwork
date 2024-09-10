package com.example.overwork.controller;

import com.example.overwork.entiry.Member;
import com.example.overwork.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    private final LoginService loginService;

    @Autowired
    public UserController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/apply")
    public String apply(Model model) {
        Member member = loginService.saveData();
//        System.out.println(member.getUsername());
        model.addAttribute("username", member.getUsername());

        return "apply";
    }

    @GetMapping("start_end")
    public String startEnd() {

        return "start_end";
    }

}


