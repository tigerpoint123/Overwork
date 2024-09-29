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
    private final WebMailService webMailService;

    public WebmailController(WebMailService webMailService) {
        this.webMailService = webMailService;
    }

    @GetMapping("/webmail")
    public String webmail(Model model) {

        return "webmail";
    }

    @PostMapping("/mail")
    public String mail(WebMail webMail,
                       @RequestParam("message") String msg, @RequestParam("address") String address,
                       @RequestParam("title") String title) {
        webMail.setAddress(address);
        webMail.setTitle(title);
        webMail.setMessage(msg);
        webMailService.mailSend(webMail);
        return "webmail";
    }
}
