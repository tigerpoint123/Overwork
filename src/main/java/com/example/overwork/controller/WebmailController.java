package com.example.overwork.controller;

import com.example.overwork.entiry.WebMail;
import com.example.overwork.service.LoginService;
import com.example.overwork.service.WebMailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebmailController {
    private final LoginService loginService;
    private final WebMailService webMailService;

    public WebmailController(LoginService loginService, WebMailService webMailService) {
        this.loginService = loginService;
        this.webMailService = webMailService;
    }

    @GetMapping("/webmail")
    public String webmail(Model model) {

        return "webmail";
    }

    @PostMapping("/mail")
    public String mail(WebMail webMail) {
        webMail.setAddress("tigerrla24@gmail.com");
        webMail.setTitle("테스트");
        webMail.setMessage("테스트 확인중");
        webMailService.mailSend(webMail);

        return "webmail";
    }
}
