package com.example.overwork.repository;

import com.example.overwork.entiry.ApplyRecord;

import java.util.List;
import java.util.Optional;

public interface ApplyRepository {
    ApplyRecord recordApplyment(ApplyRecord applyRecord);
    List<ApplyRecord> allRecordApplymentList();
    List<ApplyRecord> findTodayApplymentList(String nowDate);
    Optional<ApplyRecord> updateStart(String date, String time);
    boolean startOrNot(String date);
    Optional<ApplyRecord> updateEnd(String nowDate, String nowTime);

}
