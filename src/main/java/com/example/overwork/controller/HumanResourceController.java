package com.example.overwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HumanResourceController {

    @GetMapping("/humanResource/humanResourceMain")
    public String humanResource() {

        return "humanResource/humanResourceMain";
    }


}
