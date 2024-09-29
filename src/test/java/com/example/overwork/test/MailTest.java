package com.example.overwork.test;

import com.example.overwork.entiry.WebMail;
import com.example.overwork.service.WebMailService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class MailTest {
    private final WebMailService webMailService;

    public MailTest(WebMailService webMailService) {
        this.webMailService = webMailService;
    }

    @Test
    void 메일전송() {
        WebMail webMail = new WebMail();

    }
}
