package com.example.overwork.controller;

import com.example.overwork.entiry.Member;
import com.example.overwork.repository.MemberRepository;
import com.example.overwork.service.LoginService;
import com.example.overwork.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    private final LoginService loginService;

    @Autowired
    public UserController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/apply")
    public String apply(Model model, Member member) {
        String username = loginService.findUserName(member);
//        model.addAttribute("username", username);

        return "apply";
    }

    @GetMapping("start_end")
    public String startEnd() {

        return "start_end";
    }
}


