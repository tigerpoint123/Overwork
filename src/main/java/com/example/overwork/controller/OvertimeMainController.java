package com.example.overwork.controller;

import com.example.overwork.entiry.Member;
import com.example.overwork.service.LoginService;
import com.example.overwork.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OvertimeMainController {
    private final MemberService memberService;
    private final LoginService loginService;

    @Autowired
    public OvertimeMainController(MemberService memberService, LoginService loginService) {
        this.memberService = memberService;
        this.loginService = loginService;
    }

    @GetMapping("/")
    public String test(Model model) {
        return "overtime";
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

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members =memberService.findMembers();
        model.addAttribute("members", members);

        return "members/memberList";
    }
}
