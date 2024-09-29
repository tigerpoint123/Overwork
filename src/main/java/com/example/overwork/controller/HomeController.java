package com.example.overwork.controller;

import com.example.overwork.entiry.Member;
import com.example.overwork.service.LoginService;
import com.example.overwork.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        return "mainHome";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password, Model model, Member member) {
        member.setUsername(username);
        member.setPassword(password);

        if(loginService.checkLogin(member)) {
            return "afterLoginOvertime";
        }
        else return "redirect:/";
    }

    @PostMapping("/signIn")
    public String signin(@RequestParam("new-username") String username,
                         @RequestParam("new-password") String password, Model model, Member member) {
        member.setUsername(username);
        member.setPassword(password);
        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/overwork/overworkMain")
    public String overworkMain(Model model) {
        model.addAttribute("member", loginService.saveData());
        return "/overwork/overworkMain";
    }

}
