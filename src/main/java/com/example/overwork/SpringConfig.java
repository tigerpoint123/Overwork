package com.example.overwork;

import com.example.overwork.repository.*;
import com.example.overwork.service.ApplyService;
import com.example.overwork.service.LoginService;
import com.example.overwork.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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
    public ApplyService applyService() {return new ApplyService(applyRepository());}

    @Bean
    public MemberRepository memberRepository() {
        return new JpaMemberRepository(em);
    }

    @Bean
    public ApplyRepository applyRepository() {
        return new JpaApplyRepository(em);
    }

    @Bean
    public TotalAdminRepository totalAdminRepository() {return new JpaTotalAdminRepository(em);}

}
