package com.example.overwork.service;

import com.example.overwork.entiry.Member;
import com.example.overwork.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class LoginService{
    Member member = new Member();

    @Autowired
    private final MemberRepository memberRepository;

    public LoginService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public boolean checkLogin(Member member) {
        this.member = member;
        Optional<Member> findByName = memberRepository.findByName(this.member.getUsername());

        if(findByName.isPresent() && this.member.getUsername().equals(findByName.get().getUsername()) && this.member.getPassword().equals(findByName.get().getPassword())) {
            return true;
        }
        else return false;
    }

    public String findUserName(Member member) {
        Optional<Member> findByName = memberRepository.findByName(member.getUsername());

        return member.getUsername();
    }

    public Member saveData() {
        return this.member;
    }
}
