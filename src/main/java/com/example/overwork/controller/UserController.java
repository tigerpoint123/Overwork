package com.example.overwork.controller;

import com.example.overwork.entiry.Member;
import com.example.overwork.entiry.ResponseDto;
import com.example.overwork.service.ApplyService;
import com.example.overwork.service.LoginService;
import com.example.overwork.service.MemberService;
import com.example.overwork.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.Map;

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

    @GetMapping("/login")
    public String login(Model model) {
        return "/page/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password, Model model, Member member) {
        member.setUsername(username);
        member.setPassword(password);
        if (memberService.loadUserByUsername(username) == null) {
            return "redirect:/login";
        } else {
            return "/page/afterLoginOvertime";
        }
    }

    @GetMapping("/signIn")
    public String signIn(Model model) {
        return "/page/signIn";
    }

    @PostMapping("/signIn")
    public String signin(@RequestParam("new-username") String username,
                         @RequestParam(value = "new-password") String password, Model model, Member member) {
        member.setUsername(username);
        member.setPassword(password);
        memberService.save(member);

        return "redirect:/";
    }

    @GetMapping("logout")
    public String logout(HttpRequest httpRequest, HttpServletResponse httpServletResponse) {
        new SecurityContextLogoutHandler().logout((HttpServletRequest) httpRequest, httpServletResponse,
                SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/logout";
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public String handleMissingServletRequestParameterException(
            MissingServletRequestParameterException ex) {
        return "paramer is null : " + ex.getParameterName();
    }

    @GetMapping("check")
    public @ResponseBody ResponseDto<?> check(@RequestParam(value = "userid") String username) {
        if (memberService.findByName(username).isEmpty()) {
            return new ResponseDto<>(1, "사용 가능", true); // db에 아이디 없으면 사용 가능 알림
        } else {
            return new ResponseDto<>(1, "사용 불가능", false);// db에 아이디 있으면 사용 불가능 알림
        }
    }

}


