package com.example.overwork.service;

import com.example.overwork.entiry.WebMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class WebMailService {

    private final JavaMailSender mailSender;
    private static final String From_address = "tigerrla24@gmail.com";

    public WebMailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void mailSend(WebMail webMail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(From_address);
        message.setTo(webMail.getAddress());
        message.setSubject(webMail.getTitle());
        message.setText(webMail.getMessage());
        mailSender.send(message);
    }
}
