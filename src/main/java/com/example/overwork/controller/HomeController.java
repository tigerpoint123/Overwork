package com.example.overwork.controller;

import com.example.overwork.service.LoginService;
import com.example.overwork.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final LoginService loginService;
    private final MemberService memberService;

    public HomeController(LoginService loginService, MemberService memberService) {
        this.loginService = loginService;
        this.memberService = memberService;
    }

    @GetMapping("/")
    public String test(Model model) {
        return "/page/mainHome";
    }


    @GetMapping("/overwork/overworkMain")
    public String overworkMain(Model model) {
        model.addAttribute("member", loginService.saveData());
        return "/overwork/overworkMain";
    }

    @GetMapping("/map")
    public String map() {
        return "map";
    }
}
