package com.example.overwork.service;

import com.example.overwork.entiry.ApplyRecord;
import com.example.overwork.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ApplyService {
    @Autowired
    private final MemberRepository memberRepository;

    public ApplyService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void makeRecord(ApplyRecord applyRecord) {
        memberRepository.recordApplyment(applyRecord);
    }
}
