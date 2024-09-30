package com.example.overwork.test;

import com.example.overwork.entiry.WebMail;
import com.example.overwork.service.WebMailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class MailTest {
    private final WebMailService webMailService;

    @Autowired
    public MailTest(WebMailService webMailService) {
        this.webMailService = webMailService;
    }

    @Test
    void 메일전송() {
        WebMail webMail = new WebMail();
        webMail.setAddress("tigerrla@naver.com");
        webMail.setMessage("test");
        webMail.setTitle("from user");

        webMailService.mailSend(webMail);

    }
}
