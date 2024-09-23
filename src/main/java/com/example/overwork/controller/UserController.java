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
import java.util.List;

@Controller
public class UserController {
    private final LoginService loginService;
    private final ApplyService applyService;

    @Autowired
    public UserController(LoginService loginService, ApplyService applyService) {
        this.loginService = loginService;
        this.applyService = applyService;
    }

    @GetMapping("/map")
    public String map() {

        return "map";
    }
}


