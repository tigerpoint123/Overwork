package com.example.overwork.repository;

import com.example.overwork.entiry.ApplyRecord;

import java.util.List;

public interface ApplyRepository {
    ApplyRecord recordApplyment(ApplyRecord applyRecord);
    List<ApplyRecord> allRecordApplymentList();
    List<ApplyRecord> findTodayApplymentList();

}
