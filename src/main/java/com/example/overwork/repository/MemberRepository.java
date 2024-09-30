package com.example.overwork.repository;

import com.example.overwork.entiry.ApplyRecord;
import com.example.overwork.entiry.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String username);
    List<Member> findAll();
}
