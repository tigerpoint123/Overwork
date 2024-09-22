package com.example.overwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TotalAdminController {

    @GetMapping("/totalAdmin/totalAdminMain")
    public String totalAdmin() {

        return "totalAdmin/totalAdminMain";
    }
}
