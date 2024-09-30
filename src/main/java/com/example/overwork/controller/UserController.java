package com.example.overwork.controller;

import com.example.overwork.entiry.ApplyRecord;
import com.example.overwork.entiry.Member;
import com.example.overwork.service.ApplyService;
import com.example.overwork.service.LoginService;
import com.example.overwork.service.MemberService;
import com.example.overwork.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.http.HttpRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {
    private final LoginService loginService;
    private final ApplyService applyService;
    private final MemberService memberService;
    private final UserService userService;

    @Autowired
    public UserController(LoginService loginService, ApplyService applyService, MemberService memberService, UserService userService) {
        this.loginService = loginService;
        this.applyService = applyService;
        this.memberService = memberService;
        this.userService = userService;
    }

    @GetMapping("/map")
    public String map() {

        return "map";
    }
    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password, Model model, Member member) {
        member.setUsername(username);
        member.setPassword(password);
        userService.loadUserByUsername(username);

        return "afterLoginOvertime";
    }

    @GetMapping("/signIn")
    public String signIn(Model model) {
        return "signIn";
    }

    @PostMapping("/signIn")
    public String signin(@RequestParam("new-username") String username,
                         @RequestParam("new-password") String password, Model model, Member member) {
        member.setUsername(username);
        member.setPassword(password);
        userService.save(member);

        return "redirect:/";
    }

    @GetMapping("logout")
    public String logout(HttpRequest httpRequest, HttpServletResponse httpServletResponse) {
        new SecurityContextLogoutHandler().logout((HttpServletRequest) httpRequest, httpServletResponse,
                SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/logout";
    }
}


