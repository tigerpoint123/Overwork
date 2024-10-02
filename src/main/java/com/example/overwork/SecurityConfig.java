package com.example.overwork;

import com.example.overwork.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.SecurityContextHolderFilter;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.context.SecurityContextRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig implements WebSecurityCustomizer {
    @Autowired
    private final MemberService memberService;

    public SecurityConfig(MemberService memberService) {
        this.memberService = memberService;
    }

    //spring security 기능 비활성화
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() { // 스프링 시큐리티 모든 기능(인증, 인가) 사용하지 않게 설정
        return (web -> web.ignoring() //아래 requestMatchers에 적힌 url에 대해 인증, 인가 서비스 적용하지 않음
                .requestMatchers("/static/**", "/templates/**"));
    }

    //특정 http 요청에 대한 웹 기반 보안구성
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable) //csrf 비활성화 (활성화 하는게 좋음. 지금은 학습 단계니까)
                .authorizeHttpRequests((authorizeRequests) -> authorizeRequests
                        .requestMatchers("/login", "/signIn", "/webmail", "/**")//특정 요청과 일치하는 url에 대한 엑세스 설정
                        .permitAll() // 누구나 접근 가능. requestMatchers의 url은 인증 인가 없이도 접근 가능
                        .anyRequest() // requestMatchers url 외의 요청에 대한 설정
                        .authenticated()) //인가x 인증o
                .formLogin(formLogin -> formLogin.loginPage("/login")
                        .loginProcessingUrl("/home").defaultSuccessUrl("/"))
                .logout(logout -> logout.logoutSuccessUrl("/overwork/overworkMain")
                        .invalidateHttpSession(true));

        return http.build();
    }

    //인증 관리자 권한 설정
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() throws Exception{
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(memberService); // 사용자 정보를 가져올 서비스를 설정
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    //패스워드 인코더로 사용할 빈
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void customize(WebSecurity web) {

    }
}
