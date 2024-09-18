package com.example.overwork.repository;

import com.example.overwork.entiry.ApplyRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplyUpdateMapping extends JpaRepository<ApplyRecord, Long> {
    Optional<ApplyRecord> findByDate(String date);
}
