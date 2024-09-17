package com.example.overwork.service;

import com.example.overwork.entiry.ApplyRecord;
import com.example.overwork.repository.ApplyRepository;
import com.example.overwork.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.function.IntPredicate;

@Service
@Transactional
public class ApplyService {
    @Autowired
    private final MemberRepository memberRepository;

    public ApplyService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public IntPredicate makeRecord(ApplyRecord applyRecord) {
        memberRepository.recordApplyment(applyRecord);
        return null;
    }

    public List<ApplyRecord> findApplyList() {
        return memberRepository.allRecordApplymentList();
    }

    public List<ApplyRecord> findTodayApplyment() {
        DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String nowDate = date.format(new Date());

        List<ApplyRecord> todayApplymentList = memberRepository.findTodayApplymentList(nowDate);
        return todayApplymentList;
    }
}
