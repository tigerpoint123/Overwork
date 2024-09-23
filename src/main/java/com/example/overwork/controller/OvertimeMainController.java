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

import java.util.List;

@Controller
public class OvertimeMainController {
    private final MemberService memberService;

    @Autowired
    public OvertimeMainController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members =memberService.findMembers();
        model.addAttribute("members", members);

        return "members/memberList";
    }
}
