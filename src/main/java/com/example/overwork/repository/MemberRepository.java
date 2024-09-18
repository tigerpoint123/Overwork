package com.example.overwork.repository;

import com.example.overwork.entiry.ApplyRecord;
import com.example.overwork.entiry.Member;
import jakarta.persistence.TypedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface MemberRepository  {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String username);
    List<Member> findAll();
    ApplyRecord recordApplyment(ApplyRecord applyRecord);
    List<ApplyRecord> allRecordApplymentList();
    List<ApplyRecord> findTodayApplymentList(String nowDate);
    Optional<ApplyRecord> updateStart(String nowDate);

    Long findID(String date);
}
