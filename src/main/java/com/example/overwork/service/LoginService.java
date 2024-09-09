package com.example.overwork.service;

import com.example.overwork.entiry.Member;
import com.example.overwork.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class LoginService {

    private final MemberRepository memberRepository;

    public LoginService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public boolean checkLogin(Member member) {
        Optional<Member> findByName = memberRepository.findByName(member.getUsername());
        if (findByName.isPresent()) {
            return true;
        } else
            return false;
    }

    public String findUserName(Member member) {
        Optional<Member> findByName = memberRepository.findByName(member.getUsername());

        return member.getUsername();
    }
}
