package com.example.overwork.service;

import com.example.overwork.entiry.ApplyRecord;
import com.example.overwork.repository.ApplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ApplyService {
    @Autowired
    private final ApplyRepository applyRepository;
    private Long id;

    public ApplyService(ApplyRepository applyRepository) {
        this.applyRepository = applyRepository;
    }

    public Long saveData(Long id) {
        this.id=id;
        return this.id;
    }

    public Long makeRecord(ApplyRecord applyRecord) {
        applyRepository.recordApplyment(applyRecord);
        return applyRecord.getId();
    }

    public List<ApplyRecord> findApplyList() {
        return applyRepository.allRecordApplymentList();
    }

    public List<ApplyRecord> findTodayApplyment() {
        DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String nowDate = date.format(new Date());

        List<ApplyRecord> todayApplymentList = applyRepository.findTodayApplymentList(nowDate);
        return todayApplymentList;
    }

    public Optional<ApplyRecord> updateStart(String date, String time) {
        applyRepository.updateStart(date, time);
        return null;
    }

    public List<ApplyRecord> findProgressList() {
        return applyRepository.allRecordApplymentList();
    }

    public boolean startOrNot(String nowDate) {
        return applyRepository.startOrNot(nowDate);
    }

    public Optional<ApplyRecord> updateEnd(String nowDate, String nowTime) {
        applyRepository.updateEnd(nowDate, nowTime);
        return null;
    }
}
