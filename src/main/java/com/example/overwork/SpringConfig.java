package com.example.overwork;

import com.example.overwork.repository.JpaMemberRepository;
import com.example.overwork.repository.MemberRepository;
import com.example.overwork.service.LoginService;
import com.example.overwork.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public LoginService loginService() {return new LoginService(memberRepository());}

    @Bean
    public MemberRepository memberRepository() {
        return new JpaMemberRepository(em);
    }

}
