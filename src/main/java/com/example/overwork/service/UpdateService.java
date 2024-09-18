package com.example.overwork.service;

import com.example.overwork.entiry.ApplyRecord;
import com.example.overwork.repository.ApplyUpdateMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateService {
    @Autowired
    private final ApplyUpdateMapping applyUpdateMapping;

    public UpdateService(ApplyUpdateMapping applyUpdateMapping) {
        this.applyUpdateMapping = applyUpdateMapping;
    }

    public Optional<ApplyRecord> getId(String date) {
        return applyUpdateMapping.findByDate(date);
    }
}
