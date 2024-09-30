package com.example.overwork.controller;

import com.example.overwork.entiry.ApplyRecord;
import com.example.overwork.entiry.Member;
import com.example.overwork.service.ApplyService;
import com.example.overwork.service.LoginService;
import com.example.overwork.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class OvertimeMainController {
    private final MemberService memberService;
    private final LoginService loginService;
    private final ApplyService applyService;

    @Autowired
    public OvertimeMainController(MemberService memberService, LoginService loginService, ApplyService applyService) {
        this.memberService = memberService;
        this.loginService = loginService;
        this.applyService = applyService;
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members =memberService.findMembers();
        model.addAttribute("members", members);

        return "members/memberList";
    }

    private void addUserName(Model model) {
        Member member = loginService.saveData();
        model.addAttribute("member", member);
    }

    @GetMapping("/apply")
    public String apply(Model model) {
        addUserName(model);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String nowDate = dateFormat.format(new Date());
        model.addAttribute("date", nowDate);
        model.addAttribute("username", loginService.saveData().getUsername());

        return "/overwork/apply";
    }

    @GetMapping("start_end")
    public String startEnd(Model model) {
        addUserName(model);

        List<ApplyRecord> list = applyService.findTodayApplyment();
        model.addAttribute("lists", list);
        DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String nowDate = date.format(new Date());

        boolean son = applyService.startOrNot(nowDate);
        model.addAttribute("start", son);
        return "start_end";
    }

    @PostMapping("/applyRecord")
    public String makeApplyRecord(@RequestParam("content") String content, ApplyRecord applyRecord, Model model) {
        Member member = loginService.saveData();
        DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat time = new SimpleDateFormat("HH:mm");
        String nowDate = date.format(new Date());
        String nowTime = time.format(new Date());

        applyRecord.setDate(nowDate);
        applyRecord.setTime(nowTime);
        applyRecord.setContent(content);
        applyRecord.setUsername(member.getUsername());

        Long id = applyService.makeRecord(applyRecord);
        applyService.saveData(id);
        model.addAttribute("member", member);

        return "afterLoginOvertime";
    }

    @GetMapping("/applyList")
    public String applyList(Model model) {
        List<ApplyRecord> lists = applyService.findApplyList();
        model.addAttribute("lists", lists);
        return "apply/applyList";
    }

    @PostMapping("/overworkStart")
    public String overworkStart(Model model) {
        DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String nowDate = date.format(new Date());
        DateFormat time = new SimpleDateFormat("HH:mm");
        String nowTime = time.format(new Date());
        applyService.updateStart(nowDate, nowTime);

        return "afterLoginOvertime";
    }

    @GetMapping("/processRecord")
    public String processRecord(Model model) {
        addUserName(model);

        List<ApplyRecord> list = applyService.findProgressList();
        model.addAttribute("lists", list);
        return "processRecord";
    }

    @PostMapping("overworkEnd")
    public String overworkEnd(Model model) {
        addUserName(model);

        DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String nowDate = date.format(new Date());
        DateFormat time = new SimpleDateFormat("HH:mm");
        String nowTime = time.format(new Date());
        applyService.updateEnd(nowDate, nowTime);

        return "afterLoginOvertime";
    }
}
