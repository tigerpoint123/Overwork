package com.example.overwork.controller;

import com.example.overwork.entiry.ApplyRecord;
import com.example.overwork.entiry.Member;
import com.example.overwork.service.ApplyService;
import com.example.overwork.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class UserController {
    private final LoginService loginService;
    private final ApplyService applyService;

    @Autowired
    public UserController(LoginService loginService, ApplyService applyService) {
        this.loginService = loginService;
        this.applyService = applyService;
    }

    @GetMapping("/apply")
    public String apply(Model model) {
        Member member = loginService.saveData();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String nowDate = dateFormat.format(new Date());
        model.addAttribute("username", member.getUsername());
        model.addAttribute("date", nowDate);

        return "/apply";
    }

    @GetMapping("start_end")
    public String startEnd() {

        return "start_end";
    }

    @PostMapping("/applyRecord")
    public String makeApplyRecord(@RequestParam("content") String content, ApplyRecord applyRecord, Model model) {
        Member member = loginService.saveData();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String nowDate = dateFormat.format(new Date());

        applyRecord.setDate(nowDate);
        applyRecord.setContent(content);
        applyRecord.setUsername(member.getUsername());

        applyService.makeRecord(applyRecord);
        model.addAttribute("member", member);

        return "afterLoginOvertime";
    }
}


